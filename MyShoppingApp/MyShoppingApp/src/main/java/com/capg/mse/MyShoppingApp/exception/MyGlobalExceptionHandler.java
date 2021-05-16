package com.capg.mse.MyShoppingApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyGlobalExceptionHandler {
	
	
	@ExceptionHandler
	
	public ResponseEntity<MyExceptionResponse> invalidCostInputByUser(InvalidCostRangeException ex) {
		
		int range1 = ex.getRange1();
		int range2 = ex.getRange2();
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Cost Range"+ range1+" and " +range2+" , please try again");
		return new ResponseEntity<MyExceptionResponse>(excResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidProductId(java.util.NoSuchElementException ex)
	{
		
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Product Id pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> inavlidCategory(InvalidCategoryByUserException ex) {
		String category = ex.getCategory();
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid category "+category+" , please try again");
		return new ResponseEntity<MyExceptionResponse>(excResponse, HttpStatus.BAD_REQUEST);
		
	}
	

}
