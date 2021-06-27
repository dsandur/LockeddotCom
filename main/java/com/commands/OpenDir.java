package com.commands;

import java.util.ArrayList;

import com.database.Global;
import com.exceptions.NoArgsFound;
import com.exceptions.TooManyArgs;
import com.utils.ConsolePrinter;
import com.utils.Utils;

public class OpenDir extends Command {
	private String dir2open;
	
	public OpenDir(String[] args) throws TooManyArgs, NoArgsFound {
		/* **************************************************************
		 * When a user seeks to open a directory
		 * He must supply only one argument
		 * Repeated, extra values will not be used.
		 * Invalid directories will be informed
		 * **************************************************************/
		if (args.length == 0 | args[0] == "") {
			throw new NoArgsFound();			
		}
		if (args.length > 1) {
			throw new TooManyArgs();
		}
		dir2open = args[0].trim();
	}

	@Override
	public boolean run() {
		/* **************************************************************
		 * The directory will have a separate file
		 * If the directory already has a file associated with it,
		 * 		=> then open and display the list of files in it
		 * If the directory has no file associated with it,
		 * 		=> then create one and show blank contents
		 * Set the opened directory as the current directory
		 * list of file is denoted by username.directoryname
		 * **************************************************************/
		if (Global.Variables.session == null) {
			ConsolePrinter.warning(Global.Warnings.NO_ACTIVE_SESSION);
			return true;
		}
		if (!Global.Variables.session.getCurrentUser().hasDirectory(dir2open)) {
			ConsolePrinter.warning(dir2open + ": " + Global.Warnings.NO_SUCH_DIRECTORY);
			return true;
		}
		String directoryFileName = Global.Variables.session.getCurrentUser().getName() + "$" + dir2open;
		if (dir2open == null | dir2open == "") {
			return true;
		}
		if (Utils.FileUtils.exists(
				Global.Constants.DIRECTORY_LOCATION, directoryFileName)) {
			
		} else {
			Utils.FileUtils.createBlankFile(Global.Constants.DIRECTORY_LOCATION + directoryFileName);
			ConsolePrinter.warning(Global.Warnings.EMPTY_DIRECTORY);
		}
		//
		Global.Variables.session.setCurrentDirectory(
				Global.Variables.session.getCurrentUser().getDirectory(dir2open)
				);
		//
		
//		ArrayList<String> userfiles = UserDirectoryHandler.read(directoryFileName);
		ArrayList<String> userfiles = Utils.FileUtils.getFileLines(directoryFileName);
		for (String userfile:userfiles) {
			Global.Variables.session.getCurrentDirectory().add(userfile);
		}
		//
		ConsolePrinter.info(userfiles.size() + " files found");
		ConsolePrinter.info("Current directory is " + Global.Variables.session.getCurrentDirectory().getName());
		return true;
	}
}
