package com.exceptions;

@SuppressWarnings("serial")
public class TooManyArgs extends Exception {

	@Override
	public String getMessage() {
		return "Too many arguments to process";
	}
	
}