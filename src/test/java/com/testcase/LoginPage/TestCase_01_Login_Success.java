package com.testcase.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_01_Login_Success extends TestHelper {

	Login_Page login = new Login_Page();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}
}
