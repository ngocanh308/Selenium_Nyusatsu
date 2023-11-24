package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Form;
import com.common.LinkText;
import com.common.Message;
import com.common.Textbox;
import com.common.Label;

public class Logout {
	
	LinkText lblIconUser = new LinkText(By.cssSelector(".nav-link--site a[href ='/usermenu/both_item_search/"));
	LinkText lblLogout = new LinkText(By.id("btn_logout"));
	
	public void logout() throws InterruptedException
	{
			Actions actions = new Actions(DriverUtils.getDriver());
			actions.moveToElement(lblIconUser.getRuntimeElement(), 0, 0);
			actions.perform();
			lblLogout.clickLinkText();
	}
}