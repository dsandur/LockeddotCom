package com.commands;

import com.utils.ConsolePrinter;

public class Help extends Command {
	
	private String helpOn = "";
	
	public Help(String[] args) {
		for (int i=0; i<args.length; i++ ) {
			helpOn +=  " " + args[i].trim();
		}
	}
	
	public Help() {
		
	}

	@Override
	public boolean run() {
		if (helpOn == null | helpOn == "") {
			ConsolePrinter.info("<<---------- Commands to use --------->>");
			ConsolePrinter.info("add dir");
			ConsolePrinter.info("Adds one or more directories for the current user"
					+ "\nSyntax: add dir <dir1>[ <dir2> <dir3> ... <dirn>]");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("add doc");
			ConsolePrinter.info("Adds one or more files to the current user directory"
					+ "\nSyntax: add doc <doc1>[ <doc2> <doc3> ... <docn>]");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("connect");
			ConsolePrinter.info("Connects to a user"
					+ "\nSyntax: connect as <username>");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("disconnect");
			ConsolePrinter.info("Disconnects from a user"
					+ "\nSyntax: disconnect");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("exit");
			ConsolePrinter.info("Exits / quits the application without saving changes"
					+ "\nSyntax: exit");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("list dir");
			ConsolePrinter.info("Shows list of directories for the connected user"
					+ "\nSyntax: list dir");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("open dir");
			ConsolePrinter.info("Opens a directory registered to the current user"
					+ "\nSyntax: open dir <dirname>");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("rem dir");
			ConsolePrinter.info("Removes one or more valid directories registered to the current user"
					+ "\nSyntax: rem dir <dir1> <dir2> ... <dirn>");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("rem doc");
			ConsolePrinter.info("Removes one or more valid files in the current user directory"
					+ "\nSyntax: rem doc <doc1> <doc2> ... <docn>");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("save");
			ConsolePrinter.info("Save the current user's directories and files within"
					+ "\nSyntax: save");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("show");
			ConsolePrinter.info("Shows documents under the current (or all) directory of the connected user"
					+ "\nSyntax: show"
					+ "\nSyntax: show <dir>");
			ConsolePrinter.info("----------------------------------------");
			ConsolePrinter.info("view");
			ConsolePrinter.info("Shows directories and files in tree fashion for the connected user"
					+ "\nSyntax: view");
			ConsolePrinter.info("<<--------- End of Help topics ------->>");
		} else {
			switch(helpOn) {
			case("add dir"): {
				ConsolePrinter.info("Adds one or more directories for the current user"
						+ "\nSyntax: add dir <dir1>[ <dir2> <dir3> ... <dirn>]");
				break;
				}
			case("add doc"): {
				ConsolePrinter.info("Adds one or more files to the current user directory"
						+ "\nSyntax: add doc <doc1>[ <doc2> <doc3> ... <docn>]");
				break;
				}
			case("connect"): {
				ConsolePrinter.info("Connects to a user"
				+ "\nSyntax: connect as <username>");
				break;
				}
			case("disconnect"): {
				ConsolePrinter.info("Disconnects from a user"
						+ "\nSyntax: disconnect");
				break;
				}
			case("exit"): {
				ConsolePrinter.info("Exits / quits the application without saving changes"
						+ "\nSyntax: exit");
				break;
				}
			case("list dir"): {
				ConsolePrinter.info("Shows list of directories for the connected user"
						+ "\nSyntax: list dir");
				break;
				}
			case("open dir"): {
				ConsolePrinter.info("Opens a directory registered to the current user"
						+ "\nSyntax: open dir <dirname>");
				break;
				}
			case("rem dir"): {
				ConsolePrinter.info("Removes one or more valid directories registered to the current user"
						+ "\nSyntax: rem dir <dir1> <dir2> ... <dirn>");
				break;
				}
			case("rem doc"): {
				ConsolePrinter.info("Removes one or more valid files in the current user directory"
						+ "\nSyntax: rem doc <doc1> <doc2> ... <docn>");
				break;
				}
			case("save"): {
				ConsolePrinter.info("Save the current user's directories and files within"
						+ "\nSyntax: save");
				break;
				}
			case("show"): {
				ConsolePrinter.info("Shows documents under the current (or all) directory of the connected user"
						+ "\nSyntax: show"
						+ "\nSyntax: show <dir>");
				break;
				}
			case("view"): {
				ConsolePrinter.info("Shows directories and files in tree fashion for the connected user"
						+ "\nSyntax: view");
				break;
				}
			default: {
				ConsolePrinter.info("Execute help to browse list of commands");
			}
		}
		
		}
		return true;
	}
}
