package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.DriverUtils;
import com.common.Textbox;

public class ChangePasswordPage {
	Textbox txtCurrentPass = new Textbox(By.xpath("//input[@id='currentPassword']"));
	Textbox txtNewPass = new Textbox(By.xpath("//input[@id='newPassword']"));
	Textbox txtConfirmPasss = new Textbox(By.xpath("//input[@id='confirmPassword']"));
	Button btnChangePass = new Button(By.xpath("//p[@class='form-actions']//input"));

	public void changePass(String curPass, String newPass, String confirmPass) throws InterruptedException {
		txtCurrentPass.type(curPass);
		txtNewPass.type(newPass);
		txtConfirmPasss.type(confirmPass);
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,1000)");
		btnChangePass.click();

	}

}
