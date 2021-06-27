package com.handlers;

public class Message {
	private int code;
	private String message;
	private String xtra;
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public String getXtra() {
		return xtra;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setXtra(String xtra) {
		this.xtra = xtra;
	}
	
	public Message(int code, String message, String xtra) {
		this.code = code;
		this.message = message;
		this.xtra = xtra;
	}
	public Message() {
	}
}
