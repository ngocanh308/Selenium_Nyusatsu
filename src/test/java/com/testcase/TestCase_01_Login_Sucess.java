package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_01_Login_Sucess extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {
		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.loginScroll(Constant.USERNAME, Constant.PASSWORD);

		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertEquals(Constant.WELCOM_MESSAGE, homePage.getWelcomeMessage());
	}
}
