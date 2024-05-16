package com.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Radio extends PageObject {

	public Radio(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void click() {
		this.getRuntimeElement().click();
	}

	public boolean isSelectRadio() {
		return this.getRuntimeElement().isSelected();
	}


}
