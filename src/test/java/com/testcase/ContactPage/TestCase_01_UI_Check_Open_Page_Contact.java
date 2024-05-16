package com.testcase.ContactPage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Contact_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

@Listeners(com.testcase.ListenerClass.class)
public class TestCase_01_UI_Check_Open_Page_Contact extends TestHelper {

	Login_Page login = new Login_Page();
	Contact_Page contact = new Contact_Page();

	@Test
	public void TC_01_Open_Success_Contact_When_Access_By_URL_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_CONTACT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_CONTACT);
	}

	@Test
	public void TC_02_Title_Window_Contact_Page_Not_Login() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_CONTACT);
	}


}