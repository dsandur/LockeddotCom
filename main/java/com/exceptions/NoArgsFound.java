package com.exceptions;


@SuppressWarnings("serial")
public class NoArgsFound extends Exception {

	@Override
	public String getMessage() {
		return "Not a single argument to process";
	}

}
