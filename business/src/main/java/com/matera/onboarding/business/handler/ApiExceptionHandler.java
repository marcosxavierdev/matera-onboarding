package com.matera.onboarding.business.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.matera.onboarding.business.exceptions.DataIntegrityViolationException;
import com.matera.onboarding.business.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardMessageException> objectNotFound(ObjectNotFoundException ex,
			HttpServletRequest request) {
		StandardMessageException error = new StandardMessageException(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardMessageException> dataIntegrityViolation(DataIntegrityViolationException ex,
			HttpServletRequest request) {
		StandardMessageException error = new StandardMessageException(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
