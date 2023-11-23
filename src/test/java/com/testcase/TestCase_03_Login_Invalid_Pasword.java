package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_03_Login_Invalid_Pasword extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();

	@Test
	public void TC_03_Login_Invalid_Pasword() throws InterruptedException {

		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		login.login(Constant.USERNAME, Constant.ARRAY_INVALID_PASSWORD[1]);

		Assert.assertEquals(Constant.ERROR_INVALID_PASSWORD, login.getErrorMessageLogin());
	}

}
