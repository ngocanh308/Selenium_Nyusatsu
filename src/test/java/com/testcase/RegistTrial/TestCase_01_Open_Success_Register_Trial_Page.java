package com.testcase.RegistTrial;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_01_Open_Success_Register_Trial_Page extends TestHelper {

	Login_Page login = new Login_Page();
	
	@Test
	public void TC_01_Open_Success_Register_Trial_When_Access_By_URL_After_Login() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
	}
	
	@Test
	public void TC_02_Open_Success_Register_Trial_When_Access_By_URL_Not_Yet_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
	}
	
	
	@Test
	public void TC_01_Open_Success_Register_Trial_When_Access_By_Click_Link_In_Top_Page_After_Login() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
	}
}