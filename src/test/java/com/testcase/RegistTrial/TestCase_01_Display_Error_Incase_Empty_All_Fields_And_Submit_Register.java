package com.testcase.RegistTrial;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Regist_Trial_Page;
import com.testcase.TestHelper;

public class TestCase_01_Display_Error_Incase_Empty_All_Fields_And_Submit_Register extends TestHelper {

	Login_Page login = new Login_Page();
	Regist_Trial_Page trial = new Regist_Trial_Page();
	
	@Test
	public void TC_01_Open_Success_Register_Trial_When_Access_By_URL_Not_Login() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
	}
	
	@Test
	public void TC_02_Title_Window_Register_Trial_Account_Not_Login() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_TRIAL);
	}
	
	@Test
	public void TC_03_Display_Error_When_No_Input_Data_And_Click_Submit_Not_Login() throws InterruptedException {
		trial.inputTrial("", "", "", "", "", "", "", "");
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_ALL);
	}
	
	@Test
	public void TC_04_Open_Success_Register_Trial_When_Access_By_URL_After_Login() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_REGISTER_TRIAL_ACCOUNT);
	}
	

	@Test
	public void TC_05_Title_Window_Register_Trial_Account_After_Login() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_TRIAL);
	}
	
	@Test
	public void TC_06_Display_Error_When_No_Input_Data_And_Click_Submit() throws InterruptedException {
		trial.inputTrial("", "", "", "", "", "", "", "");
		Assert.assertEquals(trial.getErrorMessageTrial(), Constant.MESSAGE_ERROR_ALL);
	}
	
	
	

}