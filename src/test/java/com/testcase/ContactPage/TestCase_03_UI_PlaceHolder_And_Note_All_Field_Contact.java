package com.testcase.ContactPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.Label;
import com.common.Textbox;
import com.common.DriverUtils;
import com.page.Contact_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;


//@Listeners(com.testcase.ListenerClass.class)
public class TestCase_03_UI_PlaceHolder_And_Note_All_Field_Contact extends TestHelper {

	Login_Page login = new Login_Page();
	Contact_Page contact = new Contact_Page();
	
	Label lblNoteName = new Label(By.xpath("//input[@id='frmName']/following-sibling::span"));
	Label lblNoteCompanyName = new Label(By.xpath("//input[@id='frmName2']/following-sibling::span"));
	Label lblNotePhone = new Label(By.xpath("//input[@id='frmTel']/following-sibling::span"));
	Label lblNoteMail = new Label(By.xpath("//input[@id='frmEmail']/following-sibling::span"));
	Label lblNoteComment = new Label(By.xpath("//textarea[@id='frmDetail']/following-sibling::span"));
	
	@Test //氏名/ご契約担当者名
	public void TC_01_Display_Correct_Text_Note_Name_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		Assert.assertEquals(contact.getTextLabel(lblNoteName), Constant.TEXT_NOTE_NAME);
	}

	@Test 
	public void TC_02_Display_Correct_PlaceHolder_Name_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		Assert.assertEquals(contact.getPlaceHolder(contact.txtName), Constant.TEXT_PLACEHOLDER_NAME);
	}
	
	@Test //会社名
	public void TC_03_Display_Correct_Text_Note_Company_Name_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(lblNoteCompanyName), Constant.TEXT_NOTE_COMPANY);
	}

	@Test 
	public void TC_04_Display_Correct_PlaceHolder_Company_Name_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getPlaceHolder(contact.txtCompanyName), Constant.TEXT_PLACEHOLDER_COMPANY);
	}
	
	@Test //電話番号
	public void TC_05_Display_Correct_Text_Note_Phone_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(lblNotePhone), Constant.TEXT_NOTE_PHONE);
	}

	@Test 
	public void TC_06_Display_Correct_PlaceHolder_Phone_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getPlaceHolder(contact.txtPhone), Constant.TEXT_PLACEHOLDER_PHONE);
	}
	
	@Test //メールアドレス
	public void TC_07_Display_Correct_PlaceHolder_Mail_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getPlaceHolder(contact.txtMail), Constant.TEXT_PLACEHOLDER_MAIL_CONTACT);
	}

	@Test //内容
	public void TC_08_Display_Correct_PlaceHolder_Note_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(lblNoteComment), Constant.TEXT_NOTE_COMMENT);
	}


}