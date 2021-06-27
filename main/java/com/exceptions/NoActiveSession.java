package com.exceptions;

@SuppressWarnings("serial")
public class NoActiveSession extends Exception {

	@Override
	public String getMessage() {
		return "No active sessions to continue";
	}

}
