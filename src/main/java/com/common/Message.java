package com.common;

import org.openqa.selenium.By;

public class Message extends PageObject {
	public Message(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public String getTextMessage() {
		return this.getRuntimeElement().getText();

	}
}
