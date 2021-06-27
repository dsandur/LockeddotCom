package com.commands;

import com.utils.ConsolePrinter;

public class Exit extends Command {

	public Exit() {}
	
	@Override
	public boolean run() {
		super.run();
		ConsolePrinter.info("Application terminated");
		return false;
	}
	
}
