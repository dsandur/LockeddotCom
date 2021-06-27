package com.handlers;

class HelpStrings{
	public final static String HELP = "";
	public final static String CONNECT = "Connects to your repository\n\tsyntax: connect <username>";
	public final static String DISCONNECT = "Disconnect from your repository " 
											+ "and quit the application\n"
											+ "\tsyntax: disconnect";
	public final static String EXIT = "Disconnect from your repository "
										+ "and quit the application\n"
										+ "\tsyntax: exit";
	public final static String QUIT = "Disconnect from your repository "
										+ "and quit the application\n"
										+ "\tsyntax: quit";
}

public class Helper {
	public static void help(String commandLine) {
		switch(commandLine) {
			case(HelpStrings.CONNECT): {
				System.out.println(HelpStrings.CONNECT);
				break;
			}
			case(HelpStrings.DISCONNECT): {
				System.out.println(HelpStrings.DISCONNECT);
				break;
			}
			case(HelpStrings.EXIT): {
				System.out.println(HelpStrings.EXIT);
				break;
			}
			case(HelpStrings.QUIT): {
				System.out.println(HelpStrings.QUIT);
				break;
			}
			case(HelpStrings.HELP): {
				System.out.println(HelpStrings.CONNECT);
				System.out.println(HelpStrings.DISCONNECT);
				System.out.println(HelpStrings.EXIT);
				System.out.println(HelpStrings.QUIT);
				break;
			}
		}
	}
}
