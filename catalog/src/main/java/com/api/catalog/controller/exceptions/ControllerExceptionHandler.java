package com.api.catalog.controller.exceptions;

import java.time.Instant;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.api.catalog.service.exceptions.NameAlreadyExistsException;
import com.api.catalog.service.exceptions.CodAlreadyExistsException;
import com.api.catalog.service.exceptions.EntityNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
		StandardError err = new StandardError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(NameAlreadyExistsException.class)
	public ResponseEntity<Object> handleNameAlreadyExistsException(NameAlreadyExistsException e, WebRequest request){
		String errorMessage = e.getMessage();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
	}
	
	@ExceptionHandler(CodAlreadyExistsException.class)
	public ResponseEntity<Object> handleCodAlreadyExistsException(CodAlreadyExistsException e){
		String errorMessage = e.getMessage();
		return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> handleDataIntegrityViolation(DataIntegrityViolationException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimeStamp(Instant.now());
		err.setStatus(HttpStatus.CONFLICT.value());
		err.setError("Conflito de registros");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(err);
	}
	
	
	
}
