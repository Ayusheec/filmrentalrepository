package com.filmrentalstore.exception;

public class InvalidException extends RuntimeException {
	public InvalidException(String errorMsg) 
	{
		super(errorMsg);
	}
}
