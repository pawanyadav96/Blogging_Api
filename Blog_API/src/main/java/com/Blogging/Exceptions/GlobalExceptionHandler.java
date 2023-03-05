package com.Blogging.Exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<MyErrorDetails> customerExceptionHandler(UserNotFound be, WebRequest req)
	{
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), be.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> notfoundHandler(NoHandlerFoundException nof, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), nof.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> illigalArgumetHandler(IllegalArgumentException ee, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<MyErrorDetails> methodarguumentexception(MethodArgumentNotValidException ex,WebRequest req)
  {
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(),
				ex.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
		
		
		
	
	  
  }
}
