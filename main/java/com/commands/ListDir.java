package com.commands;

import com.database.Global;
import com.utils.ConsolePrinter;

public class ListDir extends Command{

	public ListDir() {}
	
	@Override
	public boolean run() {
		/* *******************************************************************
		 * A connected user expects to see this directories
		 * *******************************************************************/
		if (Global.Variables.session == null) {
			ConsolePrinter.error(Global.Warnings.NO_ACTIVE_SESSION);
			return true;
		} else {
			Global.Variables.session.getCurrentUser().showDirectories();
			return true;
		}
	}
	
}
