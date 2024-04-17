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

public class TestCase_04_Check_Account_04 extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	BothSearch_Page both = new BothSearch_Page();
	Anken_Page anken = new Anken_Page();

	@Test
	public void TC_01_Account04_Login_Sucess() throws Exception {
		login.login(Constant.LIST_USERNAME[3], Constant.LIST_PASSWORD[3]);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test // 1. BUDGET PAGE
	public void TC_02_Account04_Open_Success_Budget_Trial_Page() throws InterruptedException {
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BUDGET_TRIAL);
	}

	@Test // 2. PAGE_ANKEN (DELETE)
	public void TC_03_Account04_Open_Success_Anken_Page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,250)");
		login.clickTabMenu("5");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_ANKEN);
	}

	@Test
	public void TC_04_Account04_Open_Anken_Yotei_Success() throws InterruptedException {
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isTabSelect("1"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_05_Account04_Delete_Anken_Yotei_Success() throws InterruptedException {
		anken.selectValueYearYotei(Constant.SELECT_YEAR_ANKEN_YOTEI);
		anken.deleteAnken(Constant.SELECT_YEAR_ANKEN_YOTEI);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_06_Account04_Open_Anken_Both() throws InterruptedException {
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isTabSelect("2"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_07_Account04_Delete_Anken_Both_Success() throws InterruptedException {
		anken.selectValueYearBoth(Constant.SELECT_YEAR_ANKEN_BOTH);
		anken.deleteAnken(Constant.SELECT_YEAR_ANKEN_BOTH);
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test // 3. PAGE_YOTE
	public void TC_08_Account04_Open_Success_Yotei_Page() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_09_Account04_Show_Popup_Download_Faile() throws InterruptedException {
		yotei.downloadCSV(Constant.TEXT_DOWNLOAD);
		Assert.assertEquals(yotei.getErrorMessagePopup(), Constant.ERROR_DOWNLOAD_CSV);

	}

	@Test
	public void TC_10_Account04_Close_Popup_Download_Faile() throws InterruptedException {
		yotei.closePopupFaild();

	}

	@Test
	public void TC_11_Account04_Bookmark_Item_Yotei_Success() throws InterruptedException, IOException {
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

	@Test // 4. PAGE_BOTH
	public void TC_12_Account04_Open_Success_Both_Page() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);

	}

	@Test
	public void TC_13_Account04_Download_File_CSV_Both_Success() throws InterruptedException, IOException {
		both.delete_File();
		String text = both.getTextSearchBoth();
		Thread.sleep(Constant.SORT_TIME);
		login.clickTabMenu("3");
		both.downloadCSV(text);
		Thread.sleep(Constant.SORT_TIME);
		try {
			Assert.assertTrue(both.isFileDownloaded(Constant.FILE_NAME_BOTH, "csv", Constant.TIME_WAIT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_14_Account04_Bookmark_Item_Both_Success() throws InterruptedException, IOException {
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

	@Test // 5. DOWNLOAD_ANKEN
	public void TC_15_Account04_Download_File_CSV_Anken_Yotei_Success() throws InterruptedException, IOException {
		both.delete_File();
		both.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("1");
		anken.selectValueYearYotei(Constant.SELECT_YEAR_ANKEN_YOTEI);
		anken.downloadAnken();
		try {
			Assert.assertTrue(anken.isFileDownloaded(Constant.FILE_NAME_YOTEI, "csv", Constant.TIME_WAIT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_16_Account04_Download_File_CSV_Anken_Both_Success() throws InterruptedException, IOException {
		both.delete_File();
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
