package com.practice.todoapp.exception;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ExceptionHandler(NotFoundException.)
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ToDoItemBadRequest extends RuntimeException {
    public ToDoItemBadRequest(String message) {
        super(message);
    }
}
