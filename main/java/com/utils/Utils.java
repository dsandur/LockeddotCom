package com.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.database.Global;
import com.handlers.Directory;
import com.handlers.User;

public class Utils {

	public static Scanner getScanner() {
		return new Scanner(System.in);
	}
	
	public static class Logger{
		public static void log(String text, String location) {
			ConsolePrinter.info(location + ">>>" + text);
		}
	}
	
	// Utility functions for general file checks, reading and writing
	public static class FileUtils{
		
		// Check whether a given file exists in the path provided
		public static boolean exists(String path, String filename) {
			File file = new File(path + filename);
			return file.exists();
		}
		
		public static boolean exists(String filename) {
			File file = new File(filename);
			return file.exists();
		}
		
		// Delete a file
		public static boolean delete(String filename)
	    {
	        File file = new File(filename);
	        if(file.delete()){
	            return true;
	        } else {
	            return false;
	        }
	    } 
		
		// get files of a folder
		public static ArrayList<String> getFileNames(String directory){
			File folder = new File(directory);
			File[] listOfFiles = folder.listFiles();
			ArrayList<String> filenames = new ArrayList<String>();

			for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
			    filenames.add(listOfFiles[i].getName());
			  } 
			}
			return filenames;
		}
		
		// Create a blank file in the given path
		public static void createBlankFile(String filename) {
			try(FileWriter writer = new FileWriter(filename);){
				
			} catch (IOException e) {
				// irrecoverable system error
				ConsolePrinter.error(e.getMessage());
				System.exit(-1);
			} 
			System.out.println("File <" + filename + "> created");
		}
		
		// Get file data as one full string without white spaces
		public static String getStringOfFileData(String filename) {
			FileReader fr = null;
			String stringOfFileData = "";
			try {
				int data;
				fr = new FileReader(filename);
				while ((data = fr.read()) != -1) {
					if ((data == (char)13) | (data == (char)10)) {
						stringOfFileData += "#";
					} else {
						stringOfFileData += (char)data;
					}
				}
			} catch (IOException e) {
				ConsolePrinter.error(e.getMessage());
				e.getStackTrace();
			} finally {
			    if (fr != null) {
			        try {
			            fr.close();
			        } catch (IOException e) {
			            // irrecoverable system error
			            ConsolePrinter.warning(e.getMessage());
			            e.getStackTrace();
			        }
			    }
			}
			return stringOfFileData;
		}
		
		// Check if the string is good (without white spaces) to be put into a file
		public static boolean isProper2Insert(String text) {
			if ((text != null | text != "") && text.length() > 0) { 
				return true;
			}
			return false;
		}
		
		// Split a text by specified separator and convert it into an array
		public static ArrayList<String> splitString2ArrayList(String text, String separator){
			ArrayList<String> arrayList2Return = new ArrayList<String>();
			String[] rawArray = text.split(separator);
			for (String elem:rawArray) {
				if (isProper2Insert(elem)) {
					arrayList2Return.add(elem.trim());
				}
			}
			return arrayList2Return;
		}
		
		// Use the array list to create a file
		public static void write(ArrayList<String> arrayList, String filename) {
			try(FileWriter writer = new FileWriter(filename)){
				for (String line:arrayList) {
					if (isProper2Insert(line)) {
						writer.write(line + (char)10);
					}
				}
			} catch (IOException e) {
				// irrecoverable system error
				ConsolePrinter.error(e.getMessage());
				e.getStackTrace();
				System.exit(-1);
			} 
		}
		// Get the arraylist of each line from the file
		public static ArrayList<String> getFileLines(String fileName){
			return splitString2ArrayList(getStringOfFileData(fileName), "#");
		}
	}
	
	// Utility functions for User objects
	public static class UserUtils{
		public static boolean exists(String username) {
			for (User user:Global.Variables.registeredUsers) {
				if (user.getName().equals(username)) {
					return true;
				}
			}
			return false;
		}
		public static void showListOfUsers() {
			for (User user:Global.Variables.registeredUsers) {
				System.out.println(user.getName());
			}
			ConsolePrinter.prompt();
		}
		public static ArrayList<String> getListofUsers() {
			ArrayList<String> userNames = new ArrayList<String>();
			for (User user:Global.Variables.registeredUsers) {
				userNames.add(user.getName());
			}
			return userNames;
		}
		public static void view(User user) {
			ConsolePrinter.info(user.getName() + " has " + user.getCountOfDirectories() + " directories");
			for (Directory dir:user.getDirectories()) {
				ConsolePrinter.info("\t" + dir.getName() + " has " + dir.getDocuments().size() + " files");
				for (String file:dir.getDocuments()) {
					ConsolePrinter.info("\t..." + file);
				}
			}
		}
	}
	
}
