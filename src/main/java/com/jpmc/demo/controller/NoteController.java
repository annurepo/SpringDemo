package com.jpmc.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jpmc.demo.exception.NoteAlreadyExistsException;
import com.jpmc.demo.exception.NoteNotFoundException;
import com.jpmc.demo.model.Note;
import com.jpmc.demo.service.INoteService;

@RestController
@RequestMapping("/api/v1")
public class NoteController {

//	http://localhost:8081/api/v1/addNote
//	http://localhost:8081/api/v1/getNoteById
//	http://localhost:8081/api/v1/getAllNote
//	http://localhost:8081/api/v1/updateNote
//	http://localhost:8081/api/v1/deleteNote

	
	@Autowired
	private INoteService noteservice;
	
	private ResponseEntity<?> responseEntity;
	
	@PostMapping("/addNote")
	public ResponseEntity<?> saveNoteDetails(@RequestBody Note noteObj) throws NoteAlreadyExistsException
	{
		try
		{
			Note newNoteObj = this.noteservice.createNote(noteObj);
			responseEntity = new ResponseEntity<>(newNoteObj,HttpStatus.CREATED);
		}
		catch(NoteAlreadyExistsException noteexp)
		{
			throw new NoteAlreadyExistsException();
		}
		return responseEntity;
	}

	
	
	@PutMapping("/updateNoteById/{id}")
	public ResponseEntity<?> saveNoteDetails(@PathVariable int id, @RequestBody Note noteObj) throws NoteAlreadyExistsException, NoteNotFoundException
	{
		Optional<Note> noteData = Optional.of(this.noteservice.getNoteById(id));
		try
		{
			if(noteData.isPresent())
			{
				Note newNoteObj = this.noteservice.updateNote(id, noteObj);
				responseEntity = new ResponseEntity<>(newNoteObj,HttpStatus.CREATED);
			}
		}
		catch(NoteNotFoundException noteexp)
		{
			throw new NoteNotFoundException();
		}
		return responseEntity;
	}

	@GetMapping("/getAllNote")
	public ResponseEntity<?> getNoteDetails()
	{
		try
		{
			responseEntity = new ResponseEntity<>(this.noteservice.getAllNotes(),HttpStatus.OK);
		}
		catch(Exception noteexp)
		{
			responseEntity = new ResponseEntity<>("Some Internal Error Occured !!!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
	@GetMapping("/getNoteById/{id}")
	public ResponseEntity<?> getNoteById(@PathVariable int id) throws NoteNotFoundException
	{
		Note noteObj = this.noteservice.getNoteById(id);
		responseEntity = new ResponseEntity<>(noteObj,HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/delNoteById/{id}")
	public ResponseEntity<?> deleteNoteById(@PathVariable int id) throws NoteNotFoundException
	{
		boolean status = this.noteservice.deleteNote(id);
		responseEntity = new ResponseEntity<>("Note with Id "+id+" deleted",HttpStatus.OK);
		return responseEntity;
	}
}
