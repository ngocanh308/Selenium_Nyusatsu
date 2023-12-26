package com.common;

import org.openqa.selenium.By;

public class Checkbox extends PageObject {

	public Checkbox(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void click() {
		this.getRuntimeElement().click();
	}

	public boolean isSelectCheckBox() {
		return this.getRuntimeElement().isSelected();
	}

}
