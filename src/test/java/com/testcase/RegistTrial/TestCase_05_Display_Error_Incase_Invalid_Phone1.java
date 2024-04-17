package com.testcase.RegistTrial;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Regist_Trial_Page;
import com.testcase.TestHelper;

public class TestCase_05_Display_Error_Incase_Invalid_Phone1 extends TestHelper {

	Login_Page login = new Login_Page();
	Regist_Trial_Page trial = new Regist_Trial_Page();
	
	@Test
	public void TC_01_Display_Error_When_Input_Invalid_Num_Phone1_And_Click_Submit_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE_INVALID[0], Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_PHONE);
	}

	@Test
	public void TC_02_Display_Error_When_Input_Invalid_Text_Phone1_And_Click_Submit_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE_INVALID[1], Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_PHONE);
	}

	@Test
	public void TC_03_Display_Error_When_Input_Invalid_Num_Phone1_And_Click_Submit_After_Login() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE_INVALID[0], Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_PHONE);
	}

	@Test
	public void TC_04_Display_Error_When_Input_Invalid_Text_Phone1_And_Click_Submit_After_Login() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE_INVALID[1], Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_PHONE);
	}

}