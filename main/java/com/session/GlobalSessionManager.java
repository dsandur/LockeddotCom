package com.session;

import java.util.ArrayList;

import com.database.Global;
import com.handlers.Directory;
import com.handlers.User;
import com.utils.ConsolePrinter;
import com.utils.Utils;

/* Executes during start-up
 * Steps:
 * => Read users file and get list of users
 * => For each user, read the list of directories
 * => Create user objects array
 */

public class GlobalSessionManager {

	public static class Session {

		private User currentUser;
		private Directory currentDirectory;
		
		public User getCurrentUser() {
			return currentUser;
		}
		public void setCurrentUser(User currentUser) {
			this.currentUser = currentUser;
		}
		public Directory getCurrentDirectory() {
			return currentDirectory;
		}
		public void setCurrentDirectory(Directory currentDirectory) {
			this.currentDirectory = currentDirectory;
		}
		public Session(User user) {
			setCurrentUser(user);
		}
	}
	
	public static ArrayList<String> getRegisteredUserNames(){
		ArrayList<String> usernames = new ArrayList<String>();
		for (User user:Global.Variables.registeredUsers) {
//			System.out.println("While retrieveing " + user.getName());
			usernames.add(user.getName());
		}
		return usernames;
	}
	
	// To save current directory
	public static void save(Directory directory) {
		Utils.FileUtils.write(
				directory.getDocuments(), 
				Global.Constants.DIRECTORY_LOCATION 
				+ Global.Variables.session.getCurrentUser().getName() 
				+ "$" + directory.getName()
				);
	}
		
	// To save a existing user
	public static void save(User user) {
		// Whether new or existing, save the names of users in the "users" master
		ArrayList<String> usernames = getRegisteredUserNames();
		Utils.FileUtils.write(
				usernames, 
				Global.Constants.LIST_OF_USERS
				);
		// Save list of directories for this user
		Utils.FileUtils.write(
				user.getDirectoryNames(), 
				Global.Constants.DIRECTORY_LOCATION + user.getName()
				);
		// for each directory, save list of files
		for (Directory dir:user.getDirectories()) {
			save(dir);
		}
	}
	
	// Run at the time of exit, to save all users
	public static void save() {
		// Save each user 
		// and list of directories 
		// and files in each directory
		ArrayList<String> usernames = getRegisteredUserNames();
		Utils.FileUtils.write(
				usernames, 
				Global.Constants.LIST_OF_USERS
				);	
		for (User user:Global.Variables.registeredUsers) {
			Utils.FileUtils.write(
				user.getDirectoryNames(), 
				Global.Constants.DIRECTORY_LOCATION + user.getName()
				);
			save(user);
		}
	}
	
	private static User signIn(String username) {
		for (User user:Global.Variables.registeredUsers) {
			if ((username != null | username != "") 		// cannot be null argument
					&& user.getName().equals(username)) {	// search in the existing users
				return user;								// The user with directories and all files get loaded
			}
		}
		ConsolePrinter.info(username + " is a new user");
		return null;
	}
	
	private static User signUp(String username) {
		return new User(username);
	}
	
	/* *******************************************************************
	 * When a user gets connected, the following will happen
	 * Condition 1: If a session is already in progress
	 * 		=> (A) if the session already belongs to the user
	 * 				=> Issue warning
	 * 		=> (B) if the session belongs to someone else
	 * 				=> Issue warning
	 * Condition 2: If no session in progress
	 * 		=> (A) if this is a registered user
	 * 				=> Sign in and establish session
	 * 		=> (B) if this is a new user
	 * 				=. Sign up and create a blank directory 
	 * *******************************************************************/
	public static boolean createSession(String username) {
		User user = null;
		if (Global.Variables.session != null) {
			if (Global.Variables.session.getCurrentUser().getName().equals(username)) {
				ConsolePrinter.warning(Global.Warnings.ALREADY_CONNECTED);
			} else {
				ConsolePrinter.warning(Global.Warnings.CANNOT_CONNECT);
			}
			return false;
		} else {
			user = signIn(username);
			if (user == null) {
				user = signUp(username);
				Global.Variables.session = new Session(user);
				Global.Variables.registeredUsers.add(user);
				Utils.FileUtils.createBlankFile(
						Global.Constants.DIRECTORY_LOCATION
						+ username
						);
				ConsolePrinter.info(Global.Warnings.USER_SIGNED_UP + username);
			} else {
				Global.Variables.session = new Session(user);
				ConsolePrinter.info(Global.Warnings.USER_SIGNED_IN + username);
			}
			ConsolePrinter.info(Global.Warnings.SESSION_ESTABLISHED);
			return true;
		}
	}
	
	public static void terminateSession() {
		Global.Variables.session = null;
	}
	
	// Retrieves file data into user objects
	private static ArrayList<User> loadInitialData(){
		ArrayList<User> users = new ArrayList<User>();
		// From the users list get all the user names
		for (String username:Utils.FileUtils.getFileLines(Global.Constants.LIST_OF_USERS)){  // refers "users" file
			ArrayList<Directory> directories = new ArrayList<Directory>();
			// For a user name, read the names of directories registered
			// Note: All directory names are provided in the file bearing user name
			if (Utils.FileUtils.exists(Global.Constants.DIRECTORY_LOCATION + username)) {    // refers to a specific user file 
																							 // that has directories
				for (String dir:Utils.FileUtils.getFileLines(Global.Constants.DIRECTORY_LOCATION + username)) {
					ArrayList<String> documents = new ArrayList<String>();
					// For each directory, read names of files saved
					// Note: All file names are provided in the file bearing username$dirname
					if (Utils.FileUtils.exists(Global.Constants.DIRECTORY_LOCATION, username + "$" + dir)) {
						for (String doc:Utils.FileUtils.getFileLines(Global.Constants.DIRECTORY_LOCATION + username + "$" + dir)) {
							documents.add(doc);
						}
					}
					directories.add(new Directory(dir, documents));
				}
			}
			users.add(new User(username, directories));
		}
		return users;
	}
	
	public static void view() {
		for (User user:Global.Variables.registeredUsers) {
			ConsolePrinter.info("User <" + user.getName() + ">");
			user.view();
		}
	}
	
	public GlobalSessionManager() {
		Global.Variables.registeredUsers = loadInitialData();
	}

}
