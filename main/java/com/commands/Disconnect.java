package com.commands;

import com.database.Global;
import com.session.GlobalSessionManager;
import com.utils.ConsolePrinter;

public class Disconnect extends Command {

	public Disconnect() {}

	@Override
	public boolean run() {
		/* *******************************************************************
		 * When a disconnect command is issued
		 * Save the current user data
		 * Terminate the session
		 * *******************************************************************/
		if (Global.Variables.session != null) {
			GlobalSessionManager.save(
					Global.Variables.session.getCurrentUser()
					);
			GlobalSessionManager.terminateSession();
			GlobalSessionManager session = new GlobalSessionManager();
			ConsolePrinter.info(Global.Warnings.DISCONNECTED);
		} else {
			ConsolePrinter.info(Global.Warnings.NO_ACTIVE_SESSION);
		}
		return true;
	}
	
}
