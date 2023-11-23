package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_06_Redirected_After_Logout extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();

	@Test
	public void TC_06_Redirected_After_Logout() throws InterruptedException {

		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.clickTabMenuHomePage(Constant.TAB_CONTACT);
		homePage.clickTabMenuHomePage(Constant.TAB_LOGOUT);
		Assert.assertEquals(Constant.HOMEURL, DriverUtils.getDriver().getCurrentUrl());
		Assert.assertFalse(homePage.doesLogoutExits());
	}

}