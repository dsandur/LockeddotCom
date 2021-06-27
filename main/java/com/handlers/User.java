package com.handlers;

import java.util.ArrayList;
import java.util.Collections;

import com.utils.ConsolePrinter;

public class User {
	
	private String name;
	private ArrayList<Directory> directories = new ArrayList<Directory>(); 
	
	// Generic getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Directory> getDirectories() {
		return directories;
	}
	public void setDirectories(ArrayList<Directory> directories) {
		this.directories = directories;
	}
	
	// User utilities
	public ArrayList<String> getDirectoryNames() {
		ArrayList<String> dirnames = new ArrayList<String>();
		for (Directory dir:this.getDirectories()) {
			dirnames.add(dir.getName());
		}
		Collections.sort(dirnames);
		return dirnames;
	}
	public int getCountOfDirectories() {
		if (this.directories == null) {
			return 0;
		}
		return this.directories.size();
	}
	public void showDirectories() {
		for (String dirname:getDirectoryNames()) {
			ConsolePrinter.info(dirname);
		}
		ConsolePrinter.info(this.getCountOfDirectories() + " directories found.");
	}
	public boolean hasAnyDirectory(String dirname) {
		if (getCountOfDirectories() == 0) {
			return false;
		}
		return true;
	}
	public boolean hasDirectory(String dirname) {
		for (String name:getDirectoryNames()) {
			if (name.equals(dirname)) {
				return true;
			}
		}
		return false;
	}
	public void add(Directory directory) {
		if (!hasDirectory(directory.getName())) {
			this.directories.add(directory);
		}
	}
	public void remove(String dirName) {
		Directory dir2remove = null;
		for (Directory dir:this.directories) {
			if (dir.getName().equals(dirName)) {
				dir2remove = dir;
			}
		}
		this.directories.remove(dir2remove);
	}
	public Directory getDirectory(String dirName) {
		Directory dir2return = null;
		for (Directory dir:this.directories) {
			if (dir.getName().equals(dirName)) {
				dir2return = dir;
				break;
			}
		}
		return dir2return;
	}
	
	// To show details
	public void view() {
		int countdir = 0;
		int countfile = 0;
		for (Directory dir:this.getDirectories()) {
			countdir += 1;
			ConsolePrinter.info("\tDirectory <" + countdir + "> " + dir.getName());
			for (String document:dir.getDocuments()) {
				countfile+= 1;
				ConsolePrinter.info("\t... ... <" + countfile + "> " + document);
			}
			countfile = 0;
		}
		countdir = 0;
		ConsolePrinter.info(this.getCountOfDirectories() + " directories found.");
		ConsolePrinter.info("---------------------------------------------");
	}
	
	/* Constructors for User Object */
	// For signin
	public User(String name, ArrayList<Directory> directories) {
		this.name = name;
		this.directories = directories;
	}
	
	// For signup
	public User(String name) {
		this.name = name;
	}
}
