package com.commands;

import com.database.Global;
import com.exceptions.TooManyArgs;
import com.utils.ConsolePrinter;

public class ShowDocs extends Command{

	String dir2Show = "";
	
	@Override
	public String getHelp() {
		return "Shows documents under the current (or all) directory of the connected user"
				+ "\nSyntax: show"
				+ "\nSyntax: show <dir>";
	}
	
	public ShowDocs(String[] args) throws TooManyArgs {
		if (args.length > 1) {
			throw new TooManyArgs();
		} else {
			if (args.length == 1) {
				dir2Show = args[0].trim();
			} 
		}
	}
	
	public ShowDocs() {}

	@Override
	public boolean run() {
		if (Global.Variables.session == null ) {
			ConsolePrinter.warning(Global.Warnings.NO_ACTIVE_SESSION);
			return true;
		} 
		if ((dir2Show == null | dir2Show == "")) {
			if (Global.Variables.session.getCurrentDirectory() == null) {
				ConsolePrinter.warning(Global.Warnings.DIRECTORY_NOT_OPEN);
			} else {
				Global.Variables.session.getCurrentDirectory().show();
			}
			return true;
		} else {
			if (Global.Variables.session.getCurrentUser().hasDirectory(dir2Show)) {
				Global.Variables.session.getCurrentUser().getDirectory(dir2Show).show();
			} else {
				ConsolePrinter.warning(Global.Warnings.NO_SUCH_DIRECTORY);
			}
			return true;
		}
	}
}
