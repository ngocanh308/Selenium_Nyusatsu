package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.common.Button;
import com.common.DriverUtils;
import com.common.Form;
import com.common.LinkText;
import com.common.Message;
import com.common.Textbox;

public class LoginPage {
	Textbox txtUserName = new Textbox(By.id("username"));
	Textbox txtPassWord = new Textbox(By.id("password"));
	Button btnLogin = new Button(By.xpath("//p[@class='form-actions']//input"));
	Message msErrorLogin = new Message(By.xpath("//p[@class='message error LoginForm']"));
	Form fmLogin = new Form(By.xpath("//form[@class='LoginForm']"));
	// forgot password
	LinkText hlpForGotPassWord = new LinkText(By.xpath("//a[.='Forgot Password page']"));
	Button btnSendInstruction = new Button(By.xpath("//input[@value='Send Instructions']"));
	// outlook mail
	Textbox txtUserNameOutLook = new Textbox(By.id("username"));
	Textbox txtPassWordOutLook = new Textbox(By.id("password"));
	Button btnLogOn = new Button(By.id("SubmitCreds"));

	public void login(String username, String password) throws InterruptedException {
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}

	public void loginScroll(String username, String password) {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}

	public void loginForgotPassWord(String name) {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		txtUserName.type(name);
		btnSendInstruction.click();
	}

	public boolean isFormLoginDisplay() {
		return fmLogin.isDisplay();
	}

	public String getErrorMessageLogin() {
		return msErrorLogin.getTextMessage();
	}

	public void clickLinkForgotPassword() {
		hlpForGotPassWord.clickLinkText();
	}
}