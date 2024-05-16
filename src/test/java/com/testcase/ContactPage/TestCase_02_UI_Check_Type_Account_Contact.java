package com.testcase.ContactPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.page.Contact_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

@Listeners(com.testcase.ListenerClass.class)
public class TestCase_02_UI_Check_Type_Account_Contact extends TestHelper {
	Login_Page login = new Login_Page();
	Contact_Page contact = new Contact_Page();

	Label lblTitleField = new Label(By.xpath("#frmContact > dl:nth-child(2) > dt"));
	Label lblChooseOne = new Label(By.cssSelector("div.txt.membership-caption"));

	@Test
	public void TC_01_Open_Success_Register_Trial_When_Access_By_URL_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_CONTACT);
	}

	@Test
	public void TC_02_Check_Title_ALL_Field_Contact() throws InterruptedException {
		assertTrue(contact.getTitleFieldContact().containsAll(Constant.LIST_TITLE_FIELD));
	}

	@Test // 現在のご利用状況
	public void TC_03_Check_List_Type_Account_Contact() throws InterruptedException {
		Assert.assertEquals(contact.getTextListAccount(), Constant.LIST_TYPE_ACCOUNT);
	}

	@Test
	public void TC_04_Check_Default_No_Option_Type_Account_Selected_Contact() throws InterruptedException {
		Assert.assertEquals(contact.isUncheckAllTypeAccount(), true);
	}

	@Test
	public void TC_05_Check_Radio_Checked_When_Selected_Eeach_Type_Contact() throws InterruptedException {
		Assert.assertEquals(contact.isSelectedTypeAccount(), true);
	}

	@Test // お問い合わせ種別
	public void TC_06_Default_Display_Text_Warning_Select_One_Type_Account_Contact() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		Assert.assertEquals(contact.getTextLabel(lblChooseOne), Constant.TEXT_DEFAULT_CHILD);
	}

	@Test
	public void TC_07_Hide_Text_Dafault_Child_When_Selected_Type_Contact() throws InterruptedException {
		Assert.assertEquals(contact.isHideTextChild(), true);
	}

	@Test
	public void TC_08_Display_Correct_List_Child_Type_Regular_When_Selected_Type_Contact() throws InterruptedException {
		Assert.assertEquals(contact.listChildType(2), Constant.LIST_CHILD_TYPE_REGULAR);
	}

	@Test
	public void TC_09_Display_Correct_List_Child_Type_Trial_When_Selected_Type_Contact() throws InterruptedException {
		Assert.assertEquals(contact.listChildType(3), Constant.LIST_CHILD_TYPE_TRIAL);
	}

	@Test
	public void TC_10_Display_Correct_List_Child_Type_Other_When_Selected_Type_Contact() throws InterruptedException {
		Assert.assertEquals(contact.listChildType(4), Constant.LIST_CHILD_TYPE_OTHER);
	}

}