package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.page.HomePage;
import com.page.RegisterPage;

public class TestCase_07_Create_New_Account extends TestHelper {
	HomePage homePage = new HomePage();
	RegisterPage register = new RegisterPage();

	@Test
	public void TC_07_Create_New_Account() throws InterruptedException {

		homePage.clickTabMenuHomePage(Constant.TAB_REGISTER);
		// create random String to join into username
		String usrNameRegister = Constant.USERNAME_REGISTER + randomNum();
		register.registerAccount(usrNameRegister, Constant.PASSWOD_REGISTER, Constant.PASSWOD_REGISTER, Constant.PID);

		Assert.assertEquals(Constant.MESSAGE_REGISTER_SUCESS, register.getMessageSucess());
	}

}
