package com.common;

import org.openqa.selenium.By;


public class Label extends PageObject {
	public Label(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public String getTextMessage() {
		return this.getRuntimeElement().getText();

	}
}