package com.main.gharrImaratApp.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> HandleInvalidException(MethodArgumentNotValidException e)
	{
		Map<String,String> response =new HashMap<>();
		
		List<ObjectError> list=e.getBindingResult().getAllErrors();
		   list.forEach((error)->
		   {
			  String name=((FieldError)error).getField();
			  String message=error.getDefaultMessage();
			  response.put(name, message);
			});
		   return new ResponseEntity<Map<String,String>>(response,HttpStatus.BAD_REQUEST);
	}

	
	

}
