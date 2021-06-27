package com.commands;

import com.database.Global;
import com.utils.ConsolePrinter;

public class View extends Command {

	public View() {
		
	}
	
	@Override
	public String getHelp() {
		return "Shows directories and files in tree fashion for the connected user"
				+ "\nSyntax: view";
	}

	@Override
	public boolean run() {
		if (Global.Variables.session != null 
				&& Global.Variables.session.getCurrentUser() != null) {
			Global.Variables.session.getCurrentUser().view();
		} else {
			ConsolePrinter.error(Global.Warnings.NO_ACTIVE_SESSION);
		}
		return true;
	}
}
