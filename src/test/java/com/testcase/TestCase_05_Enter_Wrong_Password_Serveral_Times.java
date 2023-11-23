package com.testcase;

import org.testng.annotations.Test;

import com.common.Constant;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_05_Enter_Wrong_Password_Serveral_Times extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();

	@Test
	public void TC_05_Enter_Wrong_Password_Serveral_Times() throws InterruptedException {

		homePage.clickTabMenuHomePage(Constant.TAB_LOGIN);
		int len = Constant.ARRAY_INVALID_PASSWORD.length;
		for (int i = 0; i < len; i++) {
			login.loginScroll(Constant.USERNAME, Constant.ARRAY_INVALID_PASSWORD[i]);
		}
	}

}
