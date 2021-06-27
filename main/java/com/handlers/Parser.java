package com.handlers;

import com.database.Global;
import com.utils.ConsolePrinter;

public class Parser {
	
	// remove text part and fetch the arguments from console
	private static String[] fetchArguments(String command, String text) {
		return command.replace(text, " ").trim().split(" ");
	}
	
	public static boolean parse(String commandLine) {
		String[] commandarguments;		
		
		if (commandLine.startsWith("exit")) {
			return Executor.exit();
		}
		
		if (commandLine.startsWith("quit")) {
			return Executor.exit();
		}
		
		if (commandLine.startsWith("connect as ")) {
			commandarguments = fetchArguments(commandLine, "connect as ");
			return Executor.connect(commandarguments);
		}
		
		if (commandLine.startsWith("disconnect")) {
			return Executor.disconnect();
		}
		
		if (commandLine.startsWith("list dir")) {
			return Executor.listDir();
		}
		
		if (commandLine.startsWith("add dir ")) {
			commandarguments = fetchArguments(commandLine, "add dir ");
			return Executor.addDir(commandarguments); 
		}
		
		if (commandLine.startsWith("rem dir ")) {
			commandarguments = fetchArguments(commandLine, "rem dir ");
			return Executor.remDir(commandarguments); 
		}
		
		if (commandLine.startsWith("open dir ")) {
			commandarguments = fetchArguments(commandLine, "open dir ");
			return Executor.openDir(commandarguments); 
		}
		
		if (commandLine.startsWith("add doc ")) {
			commandarguments = fetchArguments(commandLine, "add doc ");
			return Executor.addDoc(commandarguments); 
		}
		
		if (commandLine.startsWith("save")) {
			return Executor.save();
		}
		
		if (commandLine.startsWith("show ")) {
			commandarguments = fetchArguments(commandLine, "show ");
			return Executor.show(commandarguments);
		}
		
		if (commandLine.startsWith("show")) {
			return Executor.show();
		}
		
		if (commandLine.startsWith("rem doc ")) {
			commandarguments = fetchArguments(commandLine, "rem doc ");
			return Executor.remDoc(commandarguments); 
		}
		
		if (commandLine.startsWith("view")) {
			return Executor.view();
		}
		
		if (commandLine.startsWith("help ")) {
			commandarguments = fetchArguments(commandLine, "help ");
			return Executor.help(commandarguments);
		}
		
		if (commandLine.startsWith("help")) {
			return Executor.help();
		}
		
		// No command provided, then keep prompting
		if (commandLine.equals("")) {
			return true;
		}
		// If unrecognized command, ask user to enter a valid command
		ConsolePrinter.warning(Global.Warnings.INVALID_COMMAND);
		return true;
	}

	
}
