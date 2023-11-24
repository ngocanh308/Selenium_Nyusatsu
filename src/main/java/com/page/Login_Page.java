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

public class Login_Page {
	LinkText lblIconLogin = new LinkText(By.cssSelector(".nav-link--login"));
	Textbox txtUserName = new Textbox(By.id("USER_EMAIL"));
	Textbox txtPassWord = new Textbox(By.id("USER_PASSWORD"));
	Button btnLogin = new Button(By.id("button_login"));
	Message msErrorLogin = new Message(By.cssSelector(".text-muted.mb-0.login_fail"));
	
	
	public void login(String username, String password) throws InterruptedException
	{
		
			lblIconLogin.clickLinkText();
			txtUserName.type(username);
			txtPassWord.type(password);
			btnLogin.click();
	}
	


	
	public String getErrorMessageLogin()
	{
		return msErrorLogin.getTextMessage();
	}
	
}
