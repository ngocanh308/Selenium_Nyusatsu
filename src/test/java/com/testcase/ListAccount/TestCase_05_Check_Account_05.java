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

public class TestCase_05_Check_Account_05 extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	BothSearch_Page both = new BothSearch_Page();
	Anken_Page anken = new Anken_Page();

	@Test
	public void TC_01_Login_Sucess() throws Exception {
		login.login(Constant.LIST_USERNAME[4], Constant.LIST_PASSWORD[4]);
		Thread.sleep(3000);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	// BUDGET PAGE

	@Test
	public void TC_02_Open_Page_Budget_Success() throws InterruptedException {
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BUDGET);
	}

	@Test
	public void TC_03_List_Item_Start_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_S.year") == 11);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_04_List_Item_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_E.year") == 11);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_05_List_Value_Droplist_Start_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_S.year", Constant.LIST_BUDGET_YEAR_FULL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_06_List_Value_Droplist_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_E.year", Constant.LIST_BUDGET_YEAR_FULL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_07_Un_Favorite_Success() throws InterruptedException {
		budget.unFavorite();
	}

	@Test
	public void TC_08_Show_Result_Success() throws InterruptedException {
		budget.searchKWBudget("anken", "2021", "2023");
		try {
			Assert.assertTrue(budget.isDisplayResultBudget());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_09_Favorite_Success() throws InterruptedException {
		budget.favoriteBudget(5);
		budget.scrollToTop(0, 250);
		try {
			Assert.assertTrue(budget.isFavoriteSucess());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	// DELETE_ANKEN
	@Test
	public void TC_10_Open_Success_Anken_Page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,250)");
		login.clickTabMenu("5");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_ANKEN);
	}

	@Test
	public void TC_11_Open_Anken_Yotei_Success() throws InterruptedException {
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isTabSelect("1"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_12_Anken_Yotei_Empty() throws InterruptedException {
		anken.selectValueYearYotei(Constant.SELECT_YEAR_ANKEN_YOTEI);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_13_Open_Anken_Both() throws InterruptedException {
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isTabSelect("2"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_14_Delete_Anken_Both_Success() throws InterruptedException {
		anken.selectValueYearBoth(Constant.SELECT_YEAR_ANKEN_BOTH);
		anken.deleteAnken(Constant.SELECT_YEAR_ANKEN_BOTH);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	// PAGE_YOTEI (Lock)
	@Test
	public void TC_15_Lock_Success_Yotei_Page() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEIU_TRIAL);
	}

	// PAGE_BOTH
	@Test
	public void TC_16_Open_Success_Both_Page() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);

	}

	@Test
	public void TC_17_Download_File_CSV_Both_Success() throws InterruptedException, IOException {
		both.delete_File();
		both.downloadCSV(Constant.TEXT_DOWNLOAD);
		Thread.sleep(2000);
		try {
			Assert.assertTrue(both.isFileDownloaded(Constant.FILE_NAME_BOTH, "csv", Constant.TIME_WAIT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_18_Bookmark_Item_Both_Success() throws InterruptedException, IOException {
		both.boomarkItem("BOTH", 3);
		both.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isBookmarkSuccess("BOTH"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	// DOWNLOAD_ANKEN

	@Test
	public void TC_19_Download_File_CSV_Anken_Both_Success() throws InterruptedException, IOException {
		anken.clickTabMenuAnken("2");
		anken.selectValueYearBoth(Constant.SELECT_YEAR_ANKEN_BOTH);
		anken.downloadAnken();
		try {
			Assert.assertTrue(anken.isFileDownloaded(Constant.FILE_NAME_BOTH, "csv", Constant.TIME_WAIT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

}
