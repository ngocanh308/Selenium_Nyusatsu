package com.testcase.BudgetSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.BudgetSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_UI_Page extends TestHelper {
	
	Login_Page  login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	

	@Test 
	public void TC_01_Open_Page_Budget_Success() throws InterruptedException {
			login.login(Constant.USERNAME, Constant.PASSWORD);
			Thread.sleep(3000);
			login.clickTabMenu("1");
			Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLBUDGET);
	}
	
	@Test 
	public void TC_02_Title_Window() throws InterruptedException {
			String title = DriverUtils.getDriver().getTitle();
			Assert.assertEquals(title, Constant.TITLE_BUDGET);			
	}
	
	
	@Test 
	public void TC_03_List_Item_Start_Year() throws InterruptedException {
			try {
				Assert.assertTrue(budget.sizeYear("DATE_S.year") == 11);				
			}catch (AssertionError e) {
				Assert.fail();
			}
	}
	
	@Test 
	public void TC_04_List_Item_End_Year() throws InterruptedException {
			try {
				Assert.assertTrue(budget.sizeYear("DATE_E.year") == 11);				
			}catch (AssertionError e) {
				Assert.fail();
			}
	}
//	@Test 
//	public void TC_03_Select_Droplist() throws InterruptedException {
//			budget.selectType("DATE_S.year", "2014");			
//	}
}
