package com.testcase.ListAccount;

import java.awt.Window;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.BudgetSearch_Page;
import com.page.Common_Page;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_02_Check_Account_02 extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	BothSearch_Page both = new BothSearch_Page();

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

	@Test // Check page Yotei
	public void TC_07_Open_Success_Yotei_Page() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLYOTEI);
	}

	@Test
	public void TC_08_Show_Popup_Download_Faile() throws InterruptedException {
		yotei.inputTextOR("o");
		Assert.assertEquals(yotei.getErrorMessagePopup(), Constant.ERROR_DOWNLOAD_CSV);

	}

	@Test
	public void TC_09_Close_Popup_Download_Faile() throws InterruptedException {
		yotei.closePopup();

	}

	@Test // Check page Both
	public void TC_10_Open_Success_Both_Page() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLBOTH);

	}

	@Test 
	public void TC_11_Download_File_CSV_Success() throws InterruptedException, IOException {
		both.inputTextOR("o");
		Thread.sleep(6000);
		try {
			Assert.assertTrue(both.isFileDownloaded("nyusatsu_king_2023", "csv", 5000));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}

	}
	
	@Test // Check page Anken
	public void TC_12_Open_Success_Anken_Page() throws InterruptedException {
		login.clickTabMenu("4");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URLHOME + Constant.URLANKEN);
	}


}
