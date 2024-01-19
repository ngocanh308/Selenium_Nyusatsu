package com.testcase.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Logout;
import com.testcase.TestHelper;

public class Testcase_07_Login_List_Account extends TestHelper {

	Login_Page login = new Login_Page();
	Logout logout = new Logout();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {

		for (int i = 0; i < Constant.LIST_USERNAME.length; i++) {
			login.login(Constant.LIST_USERNAME[i], Constant.LIST_PASSWORD[i]);
			Thread.sleep(2000);
			Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
			logout.logout();
			Thread.sleep(2000);
			Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME );
			
		}
	}
}