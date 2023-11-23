package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.Message;

public class HomePage {

	private final String tabMenuHomePage = "//span[contains(text(),'%s')]";
	Message lblWelcomeMessage = new Message(By.xpath("//h1[contains(text(),'Welcome to Safe Railway')]"));

	public void clickTabMenuHomePage(String text) {
		DriverUtils.getDriver().findElement(By.xpath(String.format(tabMenuHomePage, text))).click();
	}

	public String getWelcomeMessage() {
		return lblWelcomeMessage.getTextMessage();
	}

	public boolean isTabDisplay(String text) {
		return DriverUtils.getDriver().findElement(By.xpath(String.format(tabMenuHomePage, text))).isDisplayed();
	}

	// check logout disappears
	public boolean doesLogoutExits() {
		List<WebElement> element = DriverUtils.getDriver().findElements(By.xpath(String.format(tabMenuHomePage, Constant.TAB_LOGOUT)));
		return element.size() == 1;
	}

}