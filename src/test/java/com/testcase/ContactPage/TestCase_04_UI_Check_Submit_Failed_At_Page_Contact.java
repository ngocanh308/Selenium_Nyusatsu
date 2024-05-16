package com.testcase.ContactPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.ultilities.Log;
import com.page.Contact_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

//@Listeners(com.testcase.ListenerClass.class)
public class TestCase_04_UI_Check_Submit_Failed_At_Page_Contact extends TestHelper {

	Login_Page login = new Login_Page();
	Contact_Page contact = new Contact_Page();

	@Test // Case input
	public void TC_01_Check_Validate_Empty_All_Field_And_Click_Submit_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		Assert.assertEquals(contact.getErrorContact(true), Constant.TEXT_ERROR_CONTACT);
	}

	@Test 
	public void TC_02_Check_Validate_When_Input_Invalid_Phone_And_Invalid_Mail_At_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.INVALID_FIELD_PHONE[0], Constant.INVALID_FIELD_MAIL[0], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.getErrorContact(false),Constant.TEXT_ERROR_CONTACT_INVALID);
	}
	
	@Test 
	public void TC_03_Check_Validate_When_Input_Invalid_Phone2_And_Invalid_Mail2_At_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.INVALID_FIELD_PHONE[1], Constant.INVALID_FIELD_MAIL[1], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.getErrorContact(false),Constant.TEXT_ERROR_CONTACT_INVALID);
	}

	@Test 
	public void TC_04_Check_Validate_When_Input_Invalid_Phone3_And_Invalid_Mail3_At_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.INVALID_FIELD_PHONE[2], Constant.INVALID_FIELD_MAIL[2], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.getErrorContact(false),Constant.TEXT_ERROR_CONTACT_INVALID);
	}
	@Test 
	public void TC_05_Check_Validate_When_Input_Invalid_Phone4_And_Invalid_Mail4_At_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.INVALID_FIELD_PHONE[3], Constant.INVALID_FIELD_MAIL[3], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.getErrorContact(false),Constant.TEXT_ERROR_CONTACT_INVALID);
	}
	@Test
	public void TC_06_Check_Validate_When_Input_Invalid_Phone5_And_Invalid_Mail2_At_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.INVALID_FIELD_PHONE[4], Constant.INVALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.getErrorContact(false),Constant.TEXT_ERROR_CONTACT_INVALID);
	}

	
}