package com.handlers;

import com.utils.ConsolePrinter;
import com.session.GlobalSessionManager;
import com.utils.Utils;

public class PerpetualRunner {
	private static boolean keepRunning = true;

	// load resources during start up
	private static void loadResources() {
		GlobalSessionManager session = new GlobalSessionManager();
	}
	
	// infinite loop 
	public static void run() {
		// Preparation
		String commandLine = "";
		loadResources();
		
		// Launch
		while (keepRunning) {
			// accept user input from the console
			commandLine = Utils.getScanner().nextLine().toLowerCase().trim(); 
			// parse the command line and take appropriate actions
			// and keep running infinitely or till user decides to exit
			keepRunning = Parser.parse(commandLine);
			if (keepRunning) {
				ConsolePrinter.prompt();
			}
		}
	}
	
}
