package com.jpmc.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="note", schema = "notedbdb")
public class Note 
{
	@Id
	@Column(name="noteId")
	private int noteId;

	@Column(name="noteTitle")
	private String noteTitle;
	
	@Column(name="noteDesc")
	private String noteDesc;
	
	@Column(name="noteCategory")
	private String noteCategory;
	
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteDesc() {
		return noteDesc;
	}
	public void setNoteDesc(String noteDesc) {
		this.noteDesc = noteDesc;
	}
	public String getNoteCategory() {
		return noteCategory;
	}
	public void setNoteCategory(String noteCategory) {
		this.noteCategory = noteCategory;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteDesc=" + noteDesc + ", noteCategory="
				+ noteCategory + "]";
	}
}