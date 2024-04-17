package com.testcase.ListAccount;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Anken_Page;
import com.page.BothSearch_Page;
import com.page.BudgetSearch_Page;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_10_Check_Account_10 extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	BothSearch_Page both = new BothSearch_Page();
	Anken_Page anken = new Anken_Page();

	@Test
	public void TC_01_Account10_Login_Sucess() throws Exception {
		login.login(Constant.LIST_USERNAME[9], Constant.LIST_PASSWORD[9]);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	

	@Test // 1. BUDGET PAGE
	public void TC_02_Account10_Open_Page_Budget_Success() throws InterruptedException {
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BUDGET);
	}

	@Test 
	public void TC_03_Account10_Time_Search_Start_Year_Bugdet() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_S.year") == 3);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test 
	public void TC_04_Account10_Time_Search_End_Year_Budget() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_E.year") == 3);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test 
	public void TC_05_Account10_Value_Droplist_Time_Search_Start_Year_Budget() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_S.year", Constant.LIST_BUDGET_YEAR_TRIAL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test 
	public void TC_06_Account10_Value_Droplist_Time_Search_End_Year_Budget() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_E.year", Constant.LIST_BUDGET_YEAR_TRIAL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_07_Account10_Un_Favorite_All_Item_In_Page_Favorite_Budget() throws InterruptedException {
		budget.unFavorite();
		login.clickTabMenu("1");
		Assert.assertEquals(budget.isEmptyFavorite(), true);
		DriverUtils.getDriver().switchTo().alert().accept();
	}

	@Test
	public void TC_08_Account10_Show_Result_Budget_Success() throws InterruptedException {
		budget.searchKWBudget(Constant.TEXT_SEARCH_BUDGET, "2021", "2023");
		try {
			Assert.assertTrue(budget.isDisplayResultBudget());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_09_Account10_Favorite_Item_Budget_Success() throws InterruptedException {
		budget.favoriteBudget(5);
		budget.scrollToTop(0, 250);
		try {
			Assert.assertTrue(budget.isFavoriteSucess());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	
	@Test // 2. PAGE_ANKEN (DELETE)
	public void TC_10_Account10_Open_Success_Anken_Page_Success() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,250)");
		login.clickTabMenu("5");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_ANKEN);
	}

	@Test
	public void TC_11_Account10_Open_Anken_Yotei_Success() throws InterruptedException {
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isTabSelect("1"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_12_Account10_Delete_Anken_Yotei_Success() throws InterruptedException {
		anken.selectValueYearYotei(Constant.SELECT_YEAR_ANKEN_YOTEI);
		anken.deleteAnken(Constant.SELECT_YEAR_ANKEN_YOTEI);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_13_Account10_Open_Anken_Both_Sucess() throws InterruptedException {
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isTabSelect("2"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test //
	public void TC_14_Account10_Delete_Anken_Both_Success() throws InterruptedException {
		anken.selectValueYearBoth(Constant.SELECT_YEAR_ANKEN_BOTH);
		anken.deleteAnken(Constant.SELECT_YEAR_ANKEN_BOTH);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	
	@Test //3.  PAGE_YOTEI
	public void TC_15_Account10_Open_Success_Yotei_Page() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_16_Account10_Show_Popup_Download_Faile_Yotei() throws InterruptedException {
		yotei.downloadCSV(Constant.TEXT_DOWNLOAD);
		Assert.assertEquals(yotei.getErrorMessagePopup(), Constant.ERROR_DOWNLOAD_CSV);

	}

	@Test
	public void TC_17_Account10_Close_Popup_Download_Faile_Yotei() throws InterruptedException {
		yotei.closePopupFaild();

	}

	@Test
	public void TC_18_Account10_Bookmark_Item_Yotei_Success() throws InterruptedException, IOException {
		yotei.boomarkItem("YOTEI", 5);
		yotei.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isBookmarkSuccess("YOTEI"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	
	@Test //4.  PAGE_BOTH
	public void TC_19_Account10_Open_Success_Both_Page() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);

	}

	@Test
	public void TC_20_Account10_Show_Popup_Download_Faile() throws InterruptedException, IOException {
		both.downloadCSV(Constant.TEXT_DOWNLOAD);
		Assert.assertEquals(both.getErrorMessagePopup(), Constant.ERROR_DOWNLOAD_CSV);
	}

	@Test
	public void TC_21_Account10_Close_Popup_Download_Faile() throws InterruptedException, IOException {
		both.closePopupFaild();
	}

	
	@Test //5.DOWNLOAD_ANKEN
	public void TC_22_Account10_Download_File_CSV_Anken_Yotei_Success() throws InterruptedException, IOException {
		both.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("1");
		anken.selectValueYearYotei(Constant.SELECT_YEAR_ANKEN_YOTEI);
		anken.downloadAnken();
		Assert.assertEquals(anken.getErrorAnken(), Constant.errorDownlaodAnken);
		
	}


}
