package com.commands;

import java.util.HashSet;
import java.util.Set;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.handlers.Directory;
import com.utils.ConsolePrinter;
import com.utils.Utils;

public class AddDir extends Command {
	
	private Set<String> dirs2create;
	
	public AddDir(String[] args) throws NoArgsFound {
		/* *******************************************************************
		 * When a user seeks to Add directories, 
		 * He must supply at least one directory name
		 * Repeated values will be suppressed
		 * *******************************************************************/
		if (args.length == 0 | args[0] == "") {
			throw new NoArgsFound();
		}
		this.dirs2create = new HashSet<>();
		for (String arg:args) {
			this.dirs2create.add(arg);
		}
	}

	@Override
	public boolean run() {
		/* *******************************************************************
		 * The directories will be created for the connected user
		 * *******************************************************************/
		if (Global.Variables.session == null) {
			ConsolePrinter.error(Global.Warnings.NO_ACTIVE_SESSION);
		} else {
			for (String dir:this.dirs2create) {
				Global.Variables.session.getCurrentUser().add(new Directory(dir));
				Utils.FileUtils.createBlankFile(
						Global.Constants.DIRECTORY_LOCATION
						+ Global.Variables.session.getCurrentUser().getName()
						+ "$" + dir
						);
			}
		}
		return true;
	}
		
}
