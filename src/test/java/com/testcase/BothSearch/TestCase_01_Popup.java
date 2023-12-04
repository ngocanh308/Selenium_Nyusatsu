package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.BothSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_Popup extends TestHelper {
	
	Login_Page  login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();
	

	@Test 
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
			login.login(Constant.USERNAME, Constant.PASSWORD);
			Thread.sleep(3000);
			login.clickTabMenu("2");
			Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLYOTEI);
	}	
	
	@Test 
	public void TC_02_Open_Page_Yotei_Success() throws InterruptedException {
		
		try {
			Assert.assertTrue(both.getListLeftPopup(Constant.LIST_LEFT_AREA));	
		}catch (AssertionError e) {
			Assert.fail();}
	}
	
}