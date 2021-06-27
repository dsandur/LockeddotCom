package com.handlers;

import java.util.ArrayList;

import com.utils.ConsolePrinter;

public class Directory{
	private String name;
	private ArrayList<String> documents = new ArrayList<String>();
	
	public ArrayList<String> getDocuments() {
		return documents;
	}
	public void setDocuments(ArrayList<String> documents) {
		this.documents = documents;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	public Directory(String name, ArrayList<String> documents) {
		this.name = name;
		this.documents = documents;
	}
	public Directory(String name) {
		this.name = name;
		}
	public void add(String docname) {
		if (!this.documents.contains(docname)) {
			this.documents.add(docname);
		}
	}
	public void remove(String docname) {
		if (this.documents.contains(docname)) {
			this.documents.remove(docname);
		}
	}
	public void show() {
		for (int i=0; i<this.documents.size(); i++) {
			ConsolePrinter.info("<" + i + "> " + this.documents.get(i));
		}
	}
}