package com.webstore.domain;

import com.webstore.service.Greeter;

public class Greeting implements Greeter {
	
	String nameOfAuthor;
	
	public void setNameOfAuthor(String nameOfAuthor) {
		this.nameOfAuthor = nameOfAuthor;
	}
	
	@Override
	public void setName(String name) {
		nameOfAuthor = name;
	}
	
	@Override
	public String getGreeting() {
		String greetingMessage = "Hello World From " + nameOfAuthor + "!";
		return greetingMessage;
	}
	
}
