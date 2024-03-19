package com.common;

import org.openqa.selenium.By;


public class Label extends PageObject {
	public Label(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public String getTextLabel() {
		return this.getRuntimeElement().getText();

	}
	public String getAttribute(String value) {
		return this.getRuntimeElement().getAttribute(value);
	}
	
}