package com.commands;

import java.util.HashSet;
import java.util.Set;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.utils.ConsolePrinter;

public class RemDoc extends Command {
	
	private Set<String> files2remove;
	
	@Override
	public String getHelp() {
		return "Removes one or more valid files in the current user directory"
				+ "\nSyntax: rem doc <doc1> <doc2> ... <docn>";
	}
	
	public RemDoc(String[] args) throws NoArgsFound {
		/* ***********************************************
		 * When the user seeks to remove a file,
		 * a directory should be open
		 * He must supply one valid file name
		 * ***********************************************/
		if (args.length == 0 | args[0] == "") {
			throw new NoArgsFound();
		}
		files2remove = new HashSet<String>();
		for (String arg:args) {
			this.files2remove.add(arg.trim());
		}
		
	}

	@Override
	public boolean run() {
		/* ***********************************************
		 * If the file exists in the current directory,
		 * it will be removed
		 * ***********************************************/
		if (Global.Variables.session.getCurrentDirectory() == null) {
			ConsolePrinter.error(Global.Warnings.NO_OPEN_DIRECTORY);
			return true;
		} 
		for (String file:files2remove) {
			Global.Variables.session.getCurrentDirectory().remove(file);	
			ConsolePrinter.info("File " + file + " removed from directory");
		}
		return true;
	}
	
	

}
