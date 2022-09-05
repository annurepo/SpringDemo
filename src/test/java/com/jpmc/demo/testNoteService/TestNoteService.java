package com.jpmc.demo.testNoteService;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import com.jpmc.demo.exception.NoteAlreadyExistsException;
import com.jpmc.demo.model.Note;
import com.jpmc.demo.repository.INoteRepository;
import com.jpmc.demo.service.NoteServiceImpl;

public class TestNoteService 
{
	
//	@Autowired
//	private INoteRepository noterepository;
//	
//	@InjectMocks
//	private NoteServiceImpl noteService;
//	
//	private Note noteObj;
//	
//	@BeforeEach
//	public void setup()
//	{
//		noteObj = new Note();
//		
//		noteObj.setNoteId(1);
//		noteObj.setNoteTitle("Java");
//		noteObj.setNoteDesc("Java Training");
//		noteObj.setNoteCategory("Technical");
//		
//		ArrayList noteList = new ArrayList();
//		noteList.add(noteObj);
//	}
//	
//	@AfterEach
//	public void tearDown()
//	{
//		noteObj = null;
//	}
//	
//	@Test
//	public void testSaveNoteSuccess() throws NoteAlreadyExistsException
//	{
//		Mockito.when(noterepository.save(noteObj)).thenReturn(noteObj);
//		
//		
//		Note createdNote = noteService.createNote(noteObj);
//		
//		Assertions.assertEquals(noteObj.getNoteTitle(),createdNote.getNoteTitle());
//	}	
}