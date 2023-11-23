package com.common;
import org.openqa.selenium.By;

import com.common.PageObject;

public class LinkText extends PageObject{

	public LinkText(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLinkText() {
		this.getRuntimeElement().click();
	}
	

}