package com.testcase.LoginPage;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.github.dockerjava.api.model.Driver;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_01_Login_Success extends TestHelper {
	
	Login_Page  login = new Login_Page();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {
			login.login(Constant.USERNAME,Constant.PASSWORD);
			Thread.sleep(2000);
			Assert.assertEquals( DriverUtils.getDriver().getCurrentUrl(), Constant.URLBOTH);
	}
}
