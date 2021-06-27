package com.commands;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.exceptions.TooManyArgs;
import com.session.GlobalSessionManager;

public class Connect extends Command {

	private String user = "";
	
	public Connect(String[] args) throws TooManyArgs, NoArgsFound {
		/* *******************************************************************
		 * When a user seeks to connect, he can supply only one argument
		 * No passwords expected
		 * *******************************************************************/
		if (args.length == 0 | (args.length > 0 & args[0] == "")) {
			throw new NoArgsFound();
		}
		if (args.length > 1) {
			throw new TooManyArgs();
		}
		this.user = args[0].trim();
	}

	@Override
	public boolean run() {
		GlobalSessionManager.createSession(user);
		if (Global.Variables.session != null) {
			return true;
		}
		return false;
	}
	
}
