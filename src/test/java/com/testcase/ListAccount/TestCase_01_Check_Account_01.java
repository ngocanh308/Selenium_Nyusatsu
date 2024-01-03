package com.testcase.ListAccount;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_01_Check_Account_01 extends TestHelper {

	Login_Page login = new Login_Page();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[0], Constant.LIST_PASSWORD[0]);
		Thread.sleep(3000);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Open_Success_Budget_Trial_Page() throws InterruptedException {
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BUDGET_TRIAL);
	}

	@Test
	public void TC_03_Lock_Page_Yote() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEIU_TRIAL);
	}
}
