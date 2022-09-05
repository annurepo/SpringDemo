package com.jpmc.demo.testcontroller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmc.demo.controller.NoteController;
import com.jpmc.demo.exception.NoteAlreadyExistsException;
import com.jpmc.demo.model.Note;
import com.jpmc.demo.service.NoteServiceImpl;

@WebMvcTest(NoteController.class)
public class NoteControllerTest 
{
	@Autowired
	private MockMvc mvc;
	
	
	@MockBean
	private NoteServiceImpl noteservice;
	
	private Note noteObj;
	
	@BeforeEach
	public void setup()
	{
		noteObj = new Note();
		
		noteObj.setNoteId(1);
		noteObj.setNoteTitle("Java");
		noteObj.setNoteDesc("Java Training");
		noteObj.setNoteCategory("Technical");
		
		ArrayList noteList = new ArrayList();
		noteList.add(noteObj);
	}
	
	@AfterEach
	public void tearDown()
	{
		noteObj = null;
	}
	
	@Test
	public void testSaveNoteSuccess() throws Exception
	{
		Mockito.when(noteservice.createNote(noteObj)).thenReturn(noteObj);
		mvc.perform(MockMvcRequestBuilders.post("/api/v1/addNote")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJSON(noteObj)))
				.andExpect(status().isCreated());
	}
	
//	@Test
//	public void testSaveNoteFailure() throws Exception
//	{
//		Mockito.when(noteservice.createNote(noteObj)).thenReturn(noteObj);
//		mvc.perform(MockMvcRequestBuilders.post("/api/v1/addNote")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(asJSON(noteObj)))
//				.andExpect(status().isConflict());
//	}
	
	private static String asJSON(Note note)
	{
		try
		{
			String noteObj = new ObjectMapper().writeValueAsString(note);
			return noteObj;
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
}