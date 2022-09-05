package com.jpmc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpmc.demo.model.Note;

@Repository
public interface INoteRepository extends JpaRepository<Note, Integer> {

	
}