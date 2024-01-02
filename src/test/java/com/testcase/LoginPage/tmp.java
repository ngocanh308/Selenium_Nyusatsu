package com.testcase.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.About_Page;
import com.testcase.TestHelper;

public class tmp extends TestHelper {
	
	About_Page  about = new About_Page();

	
	// Scroll  to element in page About
	@Test
	public void TC_01_Scroll_Down_Abtract_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_ABOUT);
		try {
			Assert.assertTrue(about.isViewPortAbstruct1("abstruct"));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_02_Scroll_Down_Subsidy_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_ABOUT);
		try {
			Assert.assertTrue(about.isViewPortAbstruct1("subsidy"));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}
}
