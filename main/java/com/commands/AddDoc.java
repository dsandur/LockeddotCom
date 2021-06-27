package com.commands;

import java.util.HashSet;
import java.util.Set;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.utils.ConsolePrinter;

public class AddDoc extends Command{

	private Set<String> files2add;
	
	public AddDoc(String[] args) throws NoArgsFound {
		/* *****************************************
		 * When the user seeks to add files 
		 * a directory must be open
		 * He must supply at least one file name
		 * Repeated values will be suppressed
		 * *****************************************/
		if (args.length == 0 | args[0] == "") {
			throw new NoArgsFound();
		}
		this.files2add = new HashSet<>();
		for (String arg:args) {
			this.files2add.add(arg);
		} 
	}

	@Override
	public boolean run() {
		/* ****************************************
		 * The list of files will be added to the 
		 * current directory
		 **************************************** */
		if (Global.Variables.session.getCurrentDirectory() == null) {
			ConsolePrinter.error(Global.Warnings.NO_OPEN_DIRECTORY);
			return true;
		} 
		for (String file:files2add) {
			Global.Variables.session.getCurrentDirectory().add(file);
			ConsolePrinter.info(file + " added");
		}
		return true;
	}

}
