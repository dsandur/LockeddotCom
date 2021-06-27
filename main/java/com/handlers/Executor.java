package com.handlers;

import com.commands.*;
import com.exceptions.NoArgsFound;
import com.exceptions.TooManyArgs;
import com.utils.ConsolePrinter;

public class Executor {

	public static boolean exit() {
		return new Exit().run();
	}
	
	public static boolean connect(String[] args) {
		try {
			return new Connect(args).run();
		} catch (TooManyArgs | NoArgsFound e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;		
	}
	
	public static boolean disconnect() {
		return new Disconnect().run();
	}
	
	public static boolean listDir() {
		return new ListDir().run();
	}
	
	public static boolean addDir(String[] args) {
		try {
			return new AddDir(args).run();
		} catch (NoArgsFound e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean remDir(String[] args) {
		try {
			return new RemDir(args).run();
		} catch (NoArgsFound e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean openDir(String[] args) {
		try {
			return new OpenDir(args).run();
		} catch (NoArgsFound | TooManyArgs e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean addDoc(String[] args) {
		try {
			return new AddDoc(args).run();
		} catch (NoArgsFound e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean save() {
		return new Save().run();
	}
	
	public static boolean show(String[] args) {
		try {
			return new ShowDocs(args).run();
		} catch (TooManyArgs e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean show() {
		return new ShowDocs().run();
	}
	
	public static boolean remDoc(String[] args) {
		try {
			return new RemDoc(args).run();
		} catch (NoArgsFound e) {
			ConsolePrinter.error(e.getMessage());
		}
		return true;
	}
	
	public static boolean view() {
		return new View().run();
	}
	
	public static boolean help(String[] args) {
		return new Help(args).run();
	}
	
	public static boolean help() {
		return new Help().run();
	}
	
}
