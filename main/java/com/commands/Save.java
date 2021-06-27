package com.commands;

import com.database.Global;
import com.session.GlobalSessionManager;
import com.utils.ConsolePrinter;

public class Save extends Command{

	public Save() {}
	
	@Override
	public String getHelp() {
		return "Save the current user's directories and files within"
				+ "\nSyntax: save";
	}

	@Override
	public boolean run() {
		/* *****************************************
		 * Saves the current user directories 
		 * 	and files in them
		 * *****************************************/
		if (Global.Variables.session != null) {
			GlobalSessionManager.save(
					Global.Variables.session.getCurrentUser()
					);
		} else {
			ConsolePrinter.warning(Global.Warnings.NO_ACTIVE_SESSION);
		}
		return true;
	}

}
