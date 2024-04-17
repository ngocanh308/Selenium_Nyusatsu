package com.page;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.common.Message;
import com.common.Textbox;

public class Regist_Trial_Page extends Common_Page {
	Label lblHeader = new Label(By.cssSelector("#apply-flow h2.ttl-type_003"));
	Textbox txtCD = new Textbox(By.id("frmDairiCD"));
	Textbox txtName = new Textbox(By.id("frmAccountname"));
	Textbox txtMail = new Textbox(By.id("frmEmail"));
	Textbox txtPhone1 = new Textbox(By.id("frmTelno1"));
	Textbox txtPhone2 = new Textbox(By.id("frmTelno2"));
	Textbox txtPhone3 = new Textbox(By.id("frmTelno3"));
	Textbox txtPassWord = new Textbox(By.id("frmPassword"));
	Textbox txtConfirmPassWord = new Textbox(By.id("frmConfPassword"));
	LinkText lnkPolicy = new LinkText(By.cssSelector("p.privacy-txt > a"));
	Button btnSubmit = new Button(By.cssSelector("button.nk-btn"));
	Message lblErrorTop = new Message(By.id("showError"));
	Label lblMail = new Label(By.id("email"));
	Label lblHeaderPolicy = new Label(By.cssSelector(".ttl-type_003,text-center"));

	public void inputTrial(String CD, String name, String mail, String phone1, String phone2, String phone3, String pass, String confirmPass) throws InterruptedException {
		txtCD.type(CD);
		txtName.type(name);
		txtMail.type(mail);
		txtPhone1.type(phone1);
		txtPhone2.type(phone2);
		txtPhone3.type(phone3);
		txtPassWord.type(pass);
		txtConfirmPassWord.type(confirmPass);
		scrollToElementTop1(btnSubmit.getRuntimeElement());
		Thread.sleep(Constant.SORT_TIME);
		btnSubmit.click();
	}

	public String randomMailRegister() {

		Constant.TEXT_MAIL = "";
		String random = UUID.randomUUID().toString();
		Constant.TEXT_MAIL = random.substring(0, Math.min(random.length(), 10)) + "automation@zuno.vc";
		return Constant.TEXT_MAIL;
	}

	public String getErrorMessageTrial() {

//		WebDriverWait wait = new WebDriverWait(DriverUtils.getDriver(), Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.stalenessOf((WebElement) lblErrorTop));
		return lblErrorTop.getTextMessage().replace("\n", "");
	}

	public String getMailFin() {
		return lblMail.getTextLabel();
	}

	public void clickLinkPolicy() throws InterruptedException {
		scrollToElementTop1(lnkPolicy.getRuntimeElement());
		Thread.sleep(Constant.SORT_TIME);
		lnkPolicy.clickLinkText();
	}
	
	public String getHeaderPolicy() {
		return lblHeaderPolicy.getTextLabel();
	}
}