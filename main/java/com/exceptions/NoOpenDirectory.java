package com.exceptions;

@SuppressWarnings("serial")
public class NoOpenDirectory extends Exception {

	@Override
	public String getMessage() {
		return "No open directories to add file into";
	}

}
