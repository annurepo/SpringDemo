package com.jpmc.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND, reason="Note Does Not Exists with this ID ..")
public class NoteNotFoundException extends Exception {

}
