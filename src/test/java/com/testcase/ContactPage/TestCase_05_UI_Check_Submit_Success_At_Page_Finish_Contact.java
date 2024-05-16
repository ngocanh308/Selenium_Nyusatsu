package com.testcase.ContactPage;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.ultilities.Log;
import com.page.Contact_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

//@Listeners(com.testcase.ListenerClass.class)
public class TestCase_05_UI_Check_Submit_Success_At_Page_Finish_Contact extends TestHelper {

	Login_Page login = new Login_Page();
	Contact_Page contact = new Contact_Page();

	
	//Check submit success all case input
	@Test // Case input 1
	public void TC_01_Navigate_Confirm_Page_Contact_When_Input_ASCII_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 1, Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_NAME_COMPANY[0], Constant.VALID_FIELD_PHONE[0], Constant.VALID_FIELD_MAIL[0], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test // confirm page 
	public void TC_02_Display_Correct_Title_Confirm_Page_Contact() throws InterruptedException {
		Assert.assertEquals(DriverUtils.getDriver().getTitle(), Constant.TITLE_CONFIRM_CONTACT);
	}
	
	@Test 
	public void TC_03_Display_Correct_Header_Confirm_Page_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(contact.lblHeaderConfirm), Constant.TEXT_HEADER_CONFIRM_CONTACT);
	}
	
	@Test 
	public void TC_04_Display_Correct_Child_Header_Confirm_Page_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(contact.lblChildHeaderConfirm), Constant.TEXT_CHILD_HEADER_CONFIRM_CONTACT);
	}
	
	
	@Test 
	public void TC_05_Display_Correct_Title_All_Field_Confirm_Page_Contact() throws InterruptedException {
		assertTrue(contact.getTitleFieldConfirmContact().containsAll(Constant.LIST_TITLE_FIELD_CONFIRM));
	}
	
	@Test
	public void TC_06_Display_Correct_In_Confirm_Page_Incase_Input_ASCIINameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);		
	}

	@Test //   finish page
	public void TC_07_Display_Correct_Title_Finish_Page_Contact() throws InterruptedException {
		Assert.assertEquals(DriverUtils.getDriver().getTitle(), Constant.TITLE_FINISH_CONTACT);
	}
	
	
	@Test 
	public void TC_08_Display_Correct_Header_Finish_Page_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextLabel(contact.lblHeaderConfirm), Constant.TEXT_HEADER_CONFIRM_CONTACT);
	}
	
	@Test 	
	public void TC_09_Display_Correct_In_Finish_Page_Incase_Input_ASCIINameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test 
	public void TC_10_Display_Correct_LinkText_TopPage_Finish_Page_Contact() throws InterruptedException {
		Assert.assertEquals(contact.LikTopPage.getTextLink(), Constant.LINK_TEXT_FINISH_TOP);
	}
	
	@Test 
	public void TC_11_Display_Correct_LinkText_TopPage_Finish_Page_Contact() throws InterruptedException {
		contact.LikTopPage.clickLinkText();
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME);
	}
	
	@Test // Case input
	public void TC_12_Navigate_Confirm_Page_Contact_When_Input_Kanji_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 2, Constant.VALID_FIELD_NAME_COMPANY[1], Constant.VALID_FIELD_NAME_COMPANY[1], Constant.VALID_FIELD_PHONE[1], Constant.VALID_FIELD_MAIL[1], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_13_Display_Correct_In_Confirm_page_Incase_Input_KanjiNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	@Test
	public void TC_14_Display_Correct_In_Finish_Page_Incase_Input_KanjiNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input 2
	public void TC_15_Navigate_Confirm_Page_Contact_When_Input_Hiragana_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 3, Constant.VALID_FIELD_NAME_COMPANY[2], Constant.VALID_FIELD_NAME_COMPANY[2], Constant.VALID_FIELD_PHONE[2], Constant.VALID_FIELD_MAIL[2], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_16_Display_Correct_In_Confirm_page_Incase_Input_HiraganaNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	@Test
	public void TC_17_Display_Correct_In_Finish_Page_Incase_Input_HiraganaNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_18_Navigate_Confirm_Page_Contact_When_Input_Katakana_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 4, Constant.VALID_FIELD_NAME_COMPANY[3], Constant.VALID_FIELD_NAME_COMPANY[3], Constant.VALID_FIELD_PHONE[3], Constant.VALID_FIELD_MAIL[3], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_19_Display_Correct_In_Confirm_page_Incase_Input_KatakanaNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	@Test
	public void TC_20_Display_Correct_In_Finish_Page_Incase_Input_KatakanaNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_21_Navigate_Confirm_Page_Contact_When_Input_Roman_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(1, 5, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_22_Display_Correct_In_Confirm_page_Incase_Input_RomanNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	@Test
	public void TC_23_Display_Correct_In_Finish_Page_Incase_Input_RomanNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_24_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(2, 1, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_25_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	@Test
	public void TC_26_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	//Check selected All rest Type Account
	@Test // Case input
	public void TC_27_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(2, 2, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_28_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_29_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_30_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(2, 3, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_31_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_32_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_33_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(2, 4, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_34_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_35_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	@Test // Case input
	public void TC_36_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(2, 5, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_37_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_38_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_39_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(3, 1, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_40_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_41_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_42_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(3, 2, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_43_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_44_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_45_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(3, 3, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_46_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_47_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
	
	@Test // Case input
	public void TC_48_Navigate_Confirm_Page_Contact_When_Input_Number_Full_Width_Field_Name_And_Company_Input_Contact() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		contact.inputContact(3, 4, Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_NAME_COMPANY[4], Constant.VALID_FIELD_PHONE[4], Constant.VALID_FIELD_MAIL[4], Constant.VALID_FIELD_NOTE);
		Assert.assertEquals(contact.isInputContactSuccess(), true);
	}

	@Test
	public void TC_49_Display_Correct_In_Confirm_page_Incase_Input_Number_Full_WidthNameCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.getInforContact();
		Assert.assertEquals(Constant.LIST_CONTACT_INPUT, Constant.LIST_CONTACT_DISPLAY);
	}
	
	//@Test
	public void TC_50_Display_Correct_In_Finish_Page_Incase_Input_NumberFullWidthCompany_ValidPhone_Valid_Mail_At_Input_Contact() throws InterruptedException {
		contact.clickFinish();
		Assert.assertEquals(contact.getTextLabelFinish(contact.lblFinish1), Constant.TEXT_FINISH1 + Constant.LIST_CONTACT_DISPLAY.get(4)+ Constant.TEXT_FINISH2);
	}
}