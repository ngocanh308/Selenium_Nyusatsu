package com.page;

import org.openqa.selenium.By;

import com.common.Button;
import com.common.Image;
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
	LinkText lnkPlicy = new LinkText(By.xpath("//a[@href='/info/policy/']//font[contains(text(),'here')]"));
	Button btnSubmit = new Button(By.id("btn-regist"));
	Message lblErrorTop = new Message(By.id("showError"));
	
	public void inputTrial( String CD, String name, String mail, String phone1, String phone2, String phone3, String pass, String confirmPass)
	{
		txtCD.type(CD);
		txtName.type(name);
		txtMail.type(mail);
		txtPhone1.type(phone1);
		txtPhone2.type(phone2);
		txtPhone3.type(phone3);
		txtPassWord.type(pass);
		txtConfirmPassWord.type(confirmPass);
		btnSubmit.click();
	}
	
	public String getErrorMessageLogin() {
		return lblErrorTop.getTextMessage();
	}
	
	
}