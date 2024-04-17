package com.testcase.RegistTrial;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Regist_Trial_Page;
import com.testcase.TestHelper;

public class TestCase_09_Regist_Account_Trial_Success extends TestHelper {

	Login_Page login = new Login_Page();
	Regist_Trial_Page trial = new Regist_Trial_Page();

	@Test
	public void TC_01_Navigate_Correct_URL_Fin_After_Register_Trial_Success_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE1_VALID, Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Thread.sleep(Constant.MIN_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(),Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_FIN);
	}
	
	@Test
	public void TC_02_Display_Correct_Mail_In_Page_Fin_After_Register_Trial_Success_Not_Login() throws InterruptedException {
		Assert.assertEquals(trial.getMailFin(), Constant.TEXT_MAIL);
	}


	@Test
	public void TC_03_Display_Error_When_Input_Invalid_Password_And_Click_Submit_After_Login() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		trial.inputTrial(Constant.TEXT_CD_VALID, Constant.TEXT_NAME_VALID_50, trial.randomMailRegister(), Constant.TEXT_PHONE1_VALID, Constant.TEXT_PHONE2_VALID, Constant.TEXT_PHONE3_VALID, Constant.TEXT_PASSWORD_VALID, Constant.TEXT_PASSWORD_VALID);
		Thread.sleep(Constant.MIN_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(),Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_FIN);
	}

	@Test
	public void TC_04_Display_Correct_Mail_In_Page_Fin_After_Register_Trial_Success_After_Login() throws InterruptedException {
		DriverUtils.getDriver().navigate().refresh();
		Assert.assertEquals(trial.getMailFin(), Constant.TEXT_MAIL);
	}

}