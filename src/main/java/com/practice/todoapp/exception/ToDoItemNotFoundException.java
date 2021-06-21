package com.practice.todoapp.exception;

public class ToDoItemNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 454543;
    private Integer errorCode;

    public ToDoItemNotFoundException(Integer errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ToDoItemNotFoundException(String message) {
        super(message);
    }
}
