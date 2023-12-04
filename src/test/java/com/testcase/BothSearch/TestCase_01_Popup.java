package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.BudgetSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_Popup extends TestHelper {
	
	Login_Page  login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	

	@Test 
	public void TC_01_Open_Page_Both_Success() throws InterruptedException {
			login.login(Constant.USERNAME, Constant.PASSWORD);
			Thread.sleep(3000);
			login.clickTabMenu("3");
			Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLBOTH);
	}	
	
}