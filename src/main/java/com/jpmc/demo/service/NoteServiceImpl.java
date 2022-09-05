package com.jpmc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpmc.demo.exception.NoteAlreadyExistsException;
import com.jpmc.demo.exception.NoteNotFoundException;
import com.jpmc.demo.model.Note;
import com.jpmc.demo.repository.INoteRepository;

@Service
public class NoteServiceImpl implements INoteService {

	@Autowired
	private INoteRepository noterepository;
	
	@Override
	public Note createNote(Note noteObj) throws NoteAlreadyExistsException{
		
		Optional<Note> optional = this.noterepository.findById(noteObj.getNoteId()); 
		
		Note createdNoteObj=null;
		
		if(optional.isPresent())
		{
			System.out.println("Note Id Already Exists .....");
		}
		else
		{
			createdNoteObj = this.noterepository.save(noteObj);
		}
		
		return createdNoteObj;
	}

	@Override
	public List<Note> getAllNotes() 
	{
		return this.noterepository.findAll();
	}

	@Override
	public Note updateNote(int noteId, Note noteObj) throws NoteNotFoundException
	{
		Optional<Note> optional = this.noterepository.findById(noteId); 
		
		Note createdNoteObj=null;
		
		if(optional.isPresent())
		{
			createdNoteObj = this.noterepository.save(noteObj);
		}
		else
		{
			System.out.println("Note with Id does not exists .....");
		}
		
		return createdNoteObj;
	}

	@Override
	public boolean deleteNote(int noteId) throws NoteNotFoundException{
		
		Optional<Note> optional = this.noterepository.findById(noteId); 
		
		boolean status= false;
		
		if(optional.isPresent())
		{
			this.noterepository.delete(optional.get());
			status=true;
		}
		else
		{
			throw new NoteNotFoundException();
		}
		return status;
	}

	@Override
	public Note getNoteById(int noteId) throws NoteNotFoundException
	{
		Optional<Note> optional = this.noterepository.findById(noteId); 
		
		Note noteObj=null;
		
		if(optional.isPresent())
		{
			noteObj = optional.get();
		}
		else
		{
			throw new NoteNotFoundException();
		}
		
		return noteObj;
	}
}