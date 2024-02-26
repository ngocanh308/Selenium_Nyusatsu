package com.testcase.YoteiSearch;

import java.time.LocalDate;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.Listbox;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_03_UI_Drop_List_Year extends TestHelper { //検索期間選択
	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	Listbox startYear = new Listbox(By.id("reg_Syear")); // List Year
	Listbox startMonth = new Listbox(By.id("reg_Smonth"));
	Listbox endYear = new Listbox(By.id("reg_Eyear"));
	Listbox endMonth = new Listbox(By.id("reg_Emonth"));
	Label noteYear = new Label(By.cssSelector("div.yotei-search__f-box-r>span.yotei-search__block-text"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Drop_List_Start_Year_Not_Support_Multi_Select() throws InterruptedException {
		Assert.assertEquals(startYear.isMultiple(), false);
	}

	@Test
	public void TC_03_Display_Correct_Current_Year_Drop_List_In_Start_Year() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(startYear.getTextDisplay(), String.valueOf(now.getYear()));
	}

	@Test
	public void TC_04_Display_Correct_Current_Month_Drop_List_In_Start_Year() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(startMonth.getTextDisplay(), String.valueOf(now.getMonthValue() - 1));
	}

	@Test
	public void TC_05_Display_Correct_Current_Year_Drop_List_In_End_Year() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(endYear.getTextDisplay(), String.valueOf(now.getYear() + 1));
	}

	@Test
	public void TC_06_Display_Correct_Current_Month_Drop_List_In_End_Month() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(endMonth.getTextDisplay(), String.valueOf(now.getMonthValue()));
	}

	@Test
	public void TC_07_Display_Correct_Note_Below_Droplist_Year() throws InterruptedException {
		Assert.assertEquals(noteYear.getTextLabel(), Constant.NOTE_YEAR);
	}
}