package com.common;
import org.openqa.selenium.By;

public class Image extends PageObject{

	public Image(By locator) {
		super(locator);
		// TODO Auto-generated constructor stub
	}
	
	public void clickImage() {
		this.getRuntimeElement().click();
	}
	

}