package com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Listbox extends PageObject {

	public Listbox(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}

	public void selectVisibleText(String text) {
		Select list = new Select(this.getRuntimeElement());
		list.selectByVisibleText(text);
	}

	public void selectValue(String value) {
		Select list = new Select(this.getRuntimeElement());
		list.selectByValue(value);
	}

	public void selectIndex(int index) {
		Select list = new Select(this.getRuntimeElement());
		list.selectByIndex(index);
	}

	public String getTextOption() {
		return this.getRuntimeElement().getText();

	}

}
