package com.infy.ems.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.ems.response.ApiResponse;
import com.infy.ems.service.EmployeeService;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);
	@ExceptionHandler 
	public ResponseEntity<ApiResponse<ErrorResponse>> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		ErrorResponse error=new ErrorResponse(
				ex.getMessage(), HttpStatus.NOT_FOUND.value(), LocalDate.now());
		ApiResponse<ErrorResponse> response=new ApiResponse<>("FAILURE", "Employee with given id is not found ", error);
		log.error("Exception occurred while processing employee request", ex);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	 public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {

        ErrorResponse error = new ErrorResponse("Internal Server error ", HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDate.now());

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler
	public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationException(MethodArgumentNotValidException ex){
		Map<String, String> errors=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->
		errors.put(error.getField(), error.getDefaultMessage())
				);
		ApiResponse<Map<String, String>> response=new ApiResponse<>("FAILURE", "Validation is failed ", errors);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
}
