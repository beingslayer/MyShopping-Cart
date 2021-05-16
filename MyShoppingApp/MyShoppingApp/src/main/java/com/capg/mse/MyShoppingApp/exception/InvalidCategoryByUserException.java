package com.capg.mse.MyShoppingApp.exception;

public class InvalidCategoryByUserException extends Exception{
	
	String category;
	
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public InvalidCategoryByUserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryByUserException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryByUserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryByUserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidCategoryByUserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

}
