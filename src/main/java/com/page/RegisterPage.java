package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.common.Button;
import com.common.DriverUtils;
import com.common.Message;
import com.common.Textbox;

public class RegisterPage {
	Textbox txtEmail = new Textbox(By.id("email"));
	Textbox txtPass = new Textbox(By.xpath("//input[@id='password']"));
	Textbox txtConfirmPass = new Textbox(By.xpath("//input[@id='confirmPassword']"));
	Textbox textPid = new Textbox(By.id("pid"));
	Button btnRegister = new Button(By.xpath("//p[@class='form-actions']//input"));
	Message lblSucessRigister = new Message(By.xpath("//h1[contains(text(),'Thank you for registering your account')]"));
	Message lblErrorMessage = new Message(By.xpath("//p[@class='message error']"));

	public void registerAccount(String email, String pass, String confirmPass, String pid) throws InterruptedException {
		txtEmail.type(email);
		txtPass.type(pass);
		txtConfirmPass.type(confirmPass);
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		textPid.type(pid);
		btnRegister.click();
	}

	public String getMessageSucess() {
		return lblSucessRigister.getTextMessage();
	}

	public String getErrorMessage() {
		return lblErrorMessage.getTextMessage();
	}
}
