package com.testcase.BothSearch;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Listbox;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_10_UI_Drop_List_Bid_Date_Nyusatsu_Both extends TestHelper { // 検索期間選択
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	Listbox startYear = new Listbox(By.id("open_Syear")); // List Year
	Listbox startMonth = new Listbox(By.cssSelector(".form-control.cbKaiSMonth"));
	Listbox startDay = new Listbox(By.cssSelector(".form-control.cbKaiSDay"));
	Listbox endYear = new Listbox(By.cssSelector(".form-control.cbKaiEYear"));
	Listbox endMonth = new Listbox(By.cssSelector(".form-control.cbKaiEMonth"));
	Listbox endDay = new Listbox(By.cssSelector(".form-control.cbKaiEDay"));
	Button btnNext3years = new Button(By.id("open_date_enable"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Drop_List_Start_Year_Not_Support_Multi_Select() throws InterruptedException {
		Assert.assertEquals(startYear.isMultiple(), false);
	}

	@Test
	public void TC_03_Display_Correct_Text_Default_Drop_List_In_Start_Year() throws InterruptedException {
		Assert.assertEquals(startYear.getTextDisplay(), Constant.TEXT_DEFAULT_BID_DATE);
	}

	@Test
	public void TC_04_Display_Correct_Current_Year_Drop_List_In_Start_Year_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(startYear, Constant.LIST_YEAR_BID_DATE), true);
	}

	@Test
	public void TC_05_Display_Correct_Current_Month_Drop_List_In_Start_Month_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(startMonth, Constant.LIST_MONTH_BID_DATE), true);
	}

	@Test
	public void TC_06_Display_Correct_Current_Date_Drop_List_In_Start_Date_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(startDay, Constant.LIST_DATE_BID_DATE), true);
	}

	@Test
	public void TC_07_Display_Correct_Current_Year_Drop_List_In_End_Year_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(endYear, Constant.LIST_YEAR_BID_DATE), true);
	}

	@Test
	public void TC_08_Display_Correct_Current_Month_Drop_List_In_End_Month_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(endMonth, Constant.LIST_MONTH_BID_DATE), true);
	}

	@Test
	public void TC_09_Display_Correct_Current_Date_Drop_List_In_End_Date_When_Selected() throws InterruptedException {
		Assert.assertEquals(both.selectValueListbox(endDay, Constant.LIST_DATE_BID_DATE), true);
	}

	@Test
	public void TC_10_Display_Correct_Current_Date_Drop_List_In_End_Date_When_Selected() throws InterruptedException {
		LocalDate now = LocalDate.now();
		String actualTime = now.toString();
		both.clickCurrentDate();
		Assert.assertEquals(both.getValueListYear(startYear, startMonth, startDay, "-"), actualTime);
	}
}