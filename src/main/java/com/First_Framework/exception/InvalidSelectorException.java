package com.First_Framework.exception;

public class InvalidSelectorException extends RuntimeException{

	String locatorType;
	
	public InvalidSelectorException(String locatorType) {
		this.locatorType = locatorType;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid locator type: "+locatorType;
	}
}
