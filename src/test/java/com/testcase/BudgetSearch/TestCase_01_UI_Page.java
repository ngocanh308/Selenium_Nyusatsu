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
	public void TC_03_Text_Header() throws InterruptedException {
				try {
					String text1 = String.join(",", budget.getTextLabelSearch());  // Change List array to List 1 string to compare
					String text2 = String.join(",", Constant.TEXT_LABEL_SEARCH);   // Change  array to  1 string to compare
					Assert.assertTrue(text1.equals(text2));
				} catch (AssertionError e) {
					Assert.fail();
				}
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
	
	@Test 
	public void TC_05_List_Value_Droplist_Start_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_S.year", Constant.LIST_BUDGET_YEAR_FULL));	
		}catch (AssertionError e) {
			Assert.fail();}
	}
	@Test 
	public void TC_06_List_Value_Droplist_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_E.year", Constant.LIST_BUDGET_YEAR_FULL));	
		}catch (AssertionError e) {
			Assert.fail();}
	}
	
	@Test 
	public void TC_07_Check_All_Text_Label() throws InterruptedException {
		
	}
	
		
}
			


