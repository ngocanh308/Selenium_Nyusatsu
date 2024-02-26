package com.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	public boolean isMultiple() {
		Select list = new Select(this.getRuntimeElement());
		return list.isMultiple();
	}
	
	public String getTextDisplay()
	{
		Select list = new Select(this.getRuntimeElement());
//		return ((WebElement) list).getAttribute("value");
		String text = list.getFirstSelectedOption().getText();
		System.out.println("Text_____________"+text);
		return text;
		
	}
	
}
