package com.jpmc.demo.service;

import java.util.List;

import com.jpmc.demo.exception.NoteAlreadyExistsException;
import com.jpmc.demo.exception.NoteNotFoundException;
import com.jpmc.demo.model.Note;

public interface INoteService 
{
	public Note createNote(Note noteObj) throws NoteAlreadyExistsException;
	public List<Note> getAllNotes();
	public Note updateNote(int noteId, Note noteObj) throws NoteNotFoundException;
	public boolean deleteNote(int noteId) throws NoteNotFoundException;
	public Note getNoteById(int noteId) throws NoteNotFoundException;
}