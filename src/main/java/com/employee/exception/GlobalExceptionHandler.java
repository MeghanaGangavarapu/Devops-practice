package com.employee.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFoundException ex) {
		Map<String, Object> errorBody = new HashMap<>();
		errorBody.put("error", "Not Found");
		errorBody.put("message", ex.getMessage());
		return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
		Map<String, Object> errorResponse = new HashMap<>();

		// Field-specific error messages
		Map<String, String> fieldErrors = ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(
				error -> error.getField(), error -> error.getDefaultMessage(), (existing, replacement) -> existing 																												
		));

		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		errorResponse.put("error", "Bad Request");
		errorResponse.put("message", "Validation failed");
		errorResponse.put("fieldErrors", fieldErrors);

		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
