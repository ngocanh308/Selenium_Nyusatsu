package com.common;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

	private WebElement runtimeElement;
	private By locator;

	public PageObject(By locator) { 
		this.locator = locator;
	}

	public WebElement getRuntimeElement() {
		waitToElementVisible(10, this.locator);
		this.runtimeElement = DriverUtils.getDriver().findElement(this.locator);
		return this.runtimeElement;
	}

	public boolean isDisplay() {
		return this.getRuntimeElement().isDisplayed();
	}
	
	public boolean isElementPresent(By locator) {
	    try {
	    	DriverUtils.getDriver().findElement(locator);
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}

	public void waitToElementVisible(int second, By locator) {
		WebDriverWait waitExplicit = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(second));
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void scrollVertical() {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
	}
	
    public void moveMouseToElement(WebElement element) {
    	Actions ac = new Actions(DriverUtils.getDriver());
    	ac.moveToElement(element).build().perform();
    }



}
