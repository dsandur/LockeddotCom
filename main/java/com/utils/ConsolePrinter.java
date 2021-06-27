package com.utils;

import com.database.Global;

public class ConsolePrinter {

	public static void prompt() {
		System.out.print(Global.Constants.CONSOLE);
	}
	public static void prompt(String prompt) {
		System.out.print(Global.Constants.CONSOLE + prompt);
	}
	public static void error(String errormsg) {
		System.err.println("Error: " + errormsg);
	}
	public static void warning(String warning) {
		System.err.println("Warning: " + warning);
	}
	public static void info(String printable) {
		System.out.println(printable);
	}
	
}
