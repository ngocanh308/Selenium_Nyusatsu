package com.testcase.ListAccount;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.BudgetSearch_Page;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;
import com.page.Anken_Page;

public class TestCase_02_Check_Account_02 extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	BothSearch_Page both = new BothSearch_Page();
	Anken_Page anken = new Anken_Page();

	@Test
	public void TC_01_Login_Sucess() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[1], Constant.LIST_PASSWORD[1]);
		Thread.sleep(3000);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLBOTH);
	}

	@Test // 1. Check Page Budget
	public void TC_02_Lock_Page_Budget() throws InterruptedException {
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLBUDGET);
	}

	@Test
	public void TC_03_List_Item_Start_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_S.year") == 3);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_04_List_Item_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.sizeYear("DATE_E.year") == 3);
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_05_List_Value_Droplist_Start_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_S.year", Constant.LIST_BUDGET_YEAR_TRIAL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_06_List_Value_Droplist_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_E.year", Constant.LIST_BUDGET_YEAR_TRIAL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test // Check page Anken
	public void TC_07_Open_Success_Anken_Page() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(0,250)");
		login.clickTabMenu("5");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLANKEN);
	}

	@Test 
	public void TC_08_Open_Anken_Yotei() throws InterruptedException {
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isTabSelect("1"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_09_Delete_Anken_Yotei_Success() throws InterruptedException {
		anken.selectValueYearYotei("2024-2022");
		anken.deleteAnken("2024-2022");
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_10_Open_Anken_Both() throws InterruptedException {
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isTabSelect("2"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test //
	public void TC_11_Delete_Anken_Both_Success() throws InterruptedException {
		anken.selectValueYearBoth("2023-2020");
		anken.deleteAnken("2023-2020");
		try {
			Assert.assertTrue(!anken.isDisplayResult());
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test // Check page Yotei
	public void TC_12_Open_Success_Yotei_Page() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLYOTEI);
	}

	@Test
	public void TC_13_Show_Popup_Download_Faile() throws InterruptedException {
		yotei.downloadCSV("o");
		Assert.assertEquals(yotei.getErrorMessagePopup(), Constant.ERROR_DOWNLOAD_CSV);

	}
	
	@Test
	public void TC_14_Close_Popup_Download_Faile() throws InterruptedException {
		yotei.closePopup();

	}
	
	@Test
	public void TC_15_Bookmark_Item_Yotei_Success() throws InterruptedException, IOException {
		yotei.boomarkItem("YOTEI",5);
		yotei.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("1");
		try {
			Assert.assertTrue(anken.isBookmarkSuccess("YOTEI"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}



	@Test // Check page Both
	public void TC_16_Open_Success_Both_Page() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLBOTH);

	}

	@Test
	public void TC_17_Download_File_CSV_Both_Success() throws InterruptedException, IOException {
		both.downloadCSV("o");
		Thread.sleep(2000);
		try {
			Assert.assertTrue(both.isFileDownloaded("nyusatsu_king_2023", "csv", 5000));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}

	@Test
	public void TC_18_Bookmark_Item_Both_Success() throws InterruptedException, IOException {
		both.boomarkItem("BOTH",3);
		both.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("2");
		try {
			Assert.assertTrue(anken.isBookmarkSuccess("BOTH"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	
	@Test // Check download CSV Anken Yotei
	public void TC_19_Download_File_CSV_Anken_Yotei_Success() throws InterruptedException, IOException {
		both.scrollToTop(0, 250);
		login.clickTabMenu("5");
		anken.clickTabMenuAnken("1");
		anken.selectValueYearYotei("2024-2022");
		anken.downloadAnken();
		try {
			Assert.assertTrue(anken.isFileDownloaded("nyusatsu_king_yotei_2023","csv",5000));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
		
	}
	
	@Test // Check download CSV Anken Both
	public void TC_20_Download_File_CSV_Anken_Both_Success() throws InterruptedException, IOException {
		anken.clickTabMenuAnken("2");
		anken.selectValueYearBoth("2023-2020");
		anken.downloadAnken();
		try {
			Assert.assertTrue(anken.isFileDownloaded("nyusatsu_king_2023","csv",5000));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
		
	}


}
