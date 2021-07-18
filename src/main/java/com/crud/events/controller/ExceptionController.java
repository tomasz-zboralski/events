package com.crud.events.controller;

import com.crud.events.exception.EventNotFoundException;
import com.crud.events.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<EventNotFoundException> exceptionHandler(EventNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }

    @ExceptionHandler
    public ResponseEntity<UserNotFoundException> exceptionHandler(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
    }
}
