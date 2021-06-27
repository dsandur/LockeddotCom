package com.database;

import java.util.ArrayList;
import com.handlers.User;
import com.session.GlobalSessionManager.Session;

public class Global {

	// Global constants
	public static class Constants {
		public final static String CONSOLE = "\nLockedMe> ";
		public final static String LIST_OF_USERS = System.getenv("LOCKEDME_HOME") + "/users.txt";
		public final static String DIRECTORY_LOCATION = System.getenv("LOCKEDME_HOME") + "/";
	}
	
	// Global variables 
	public static class Variables {
		public static ArrayList<User> registeredUsers = null;
		public static Session session = null;
	}
	
	// Global Warnings
	public static class Warnings {
		public final static String INVALID_COMMAND = "Invalid command. Run 'help' for more info";
		public final static String NO_REGISTERED_DIRECTORIES = "No registered directories found";
		public final static String ALREADY_CONNECTED = "Session already in progress for this user";
		public final static String SESSION_ESTABLISHED = "Session established\nReady to accept commands";
		public final static String CANNOT_CONNECT = "Session in progress.\nDisconnect from current user to connect";
		public final static String DISCONNECTED = "Session disconnected";
		public final static String READY_TO_SERVE = "No sessions in progress. Ready to accept commands";
		public final static String NO_ACTIVE_SESSION = "No active sessions. Pl connect to work";
		public final static String NO_SUCH_DIRECTORY = "No such directory for this user";
		public final static String EMPTY_DIRECTORY = "No files found in this directory";
		public final static String NO_OPEN_DIRECTORY = "No open directory to add files to";
		public final static String SAVE_DIRECTORY = "You must save the directory";
		public final static String DIRECTORY_NOT_OPEN = "You must open or specify a directory to show it's contents";
		public final static String USER_SIGNED_UP = "Signed up as ";
		public final static String USER_SIGNED_IN = "Signed in as ";
		public final static String DIRECTORY_REMOVED_SUCCESSFULLY = "Directory removed with all it's contents";
	}
}
