package com.infy.ems.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler 
	public ResponseEntity<ErrorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		ErrorResponse error=new ErrorResponse(
				ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDate.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	 public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ErrorResponse error = new ErrorResponse("Internal Server error ", HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDate.now());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->
		errors.put(error.getField(), error.getDefaultMessage())
				);
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
