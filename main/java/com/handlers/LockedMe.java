package com.handlers;

import com.utils.ConsolePrinter;

public class LockedMe {
	public static void main(String[] args) {
		
		ConsolePrinter.info("Loading resources from path: " + System.getenv("LOCKEDME_HOME"));
		
		ConsolePrinter.info("Welcome to LockedMe.com \nYour personal digital locker");
		ConsolePrinter.prompt();
		PerpetualRunner.run();
	}
}
