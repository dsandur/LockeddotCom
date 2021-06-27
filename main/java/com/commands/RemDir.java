package com.commands;

import java.util.HashSet;
import java.util.Set;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.utils.ConsolePrinter;
import com.utils.Utils;

public class RemDir extends Command {
	
	private Set<String> dirs2remove;
	
	public RemDir(String[] args) throws NoArgsFound {
		/* *******************************************************************
		 * When a user seeks to remove one or more directories, 
		 * He must supply at least one directory name
		 * Repeated values will be suppressed
		 * Invalid directories will be informed
		 * *******************************************************************/
		if (args.length == 0 | args[0] == "") {
			throw new NoArgsFound();
		}
		this.dirs2remove = new HashSet<>();
		for (String arg:args) {
			if (Global.Variables.session.getCurrentUser().hasDirectory(arg.trim())) {
				this.dirs2remove.add(arg.trim());
			} else {
				ConsolePrinter.warning(arg + ": " + Global.Warnings.NO_SUCH_DIRECTORY);
			}
		}
		
	}
	
	@Override
	public boolean run() {
		/* *******************************************************************
		 * The directories will be removed for the connected user
		 * *******************************************************************/
		if (Global.Variables.session == null) {
			ConsolePrinter.error(Global.Warnings.NO_ACTIVE_SESSION);
			return true;
		} else {
			
			for (String dir:this.dirs2remove) {
				Global.Variables.session.getCurrentUser().remove(dir);
				if (Utils.FileUtils.delete(
						Global.Constants.DIRECTORY_LOCATION + Global.Variables.session.getCurrentUser().getName()
						+ "$" + dir
						)) {
					ConsolePrinter.info(Global.Warnings.DIRECTORY_REMOVED_SUCCESSFULLY);
				}
			}
		}
		Global.Variables.session.getCurrentUser().showDirectories();
		return true;
		}
}
