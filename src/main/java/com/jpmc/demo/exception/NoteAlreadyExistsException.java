package com.jpmc.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT, reason="Note Already Exists in DB with this ID ..")
public class NoteAlreadyExistsException extends Exception {

}
