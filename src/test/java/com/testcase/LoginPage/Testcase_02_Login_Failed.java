package com.testcase.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class Testcase_02_Login_Failed extends TestHelper {

	Login_Page login = new Login_Page();

	@Test
	public void TC_01_Login_Invalid_Password() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.ARRAY_INVALID_PASSWORD[2]);
		Assert.assertEquals(login.getErrorMessageLogin(), Constant.ERROR_LOGIN);
	}

	@Test
	public void TC_02_Login_Invalid_Password() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		login.login(Constant.ARRAY_INVALID_USERNAME[1], Constant.PASSWORD);
		Assert.assertEquals(login.getErrorMessageLogin(), Constant.ERROR_LOGIN);
	}

	@Test
	public void TC_03_Login_Empty_Username() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		login.login("", Constant.PASSWORD);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME);
	}

	@Test
	public void TC_04_Login_Empty_Password() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		login.login(Constant.USERNAME, "");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME);
	}
}
