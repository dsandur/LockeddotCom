package com.commands;

import com.interfaces.CommandRunner;

public abstract class Command implements CommandRunner{
	private String argument;
	private String help;
	public String getArgument() {
		return argument;
	}
	public void setArgument(String argument) {
		this.argument = argument;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public boolean run() {
		return true;
	}
}
