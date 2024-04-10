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

public class TestCase_03_UI_Drop_List_Year_Common_Both extends TestHelper { // 検索期間選択
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	Listbox startYear = new Listbox(By.id("reg_Syear")); // List Year
	Listbox startMonth = new Listbox(By.id("reg_Smonth"));
	Listbox startDay = new Listbox(By.id("reg_Sday"));
	Listbox endYear = new Listbox(By.id("reg_Eyear"));
	Listbox endMonth = new Listbox(By.id("reg_Emonth"));
	Listbox endDay = new Listbox(By.id("reg_Eday"));
	Button btnNext3years = new Button(By.id("chk_one_year_from_start_date"));
	Button btnPre3years = new Button(By.id("chk_past_year"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
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
	public void TC_05_Display_Correct_Current_Day_Drop_List_In_Start_Year() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(startDay.getTextDisplay(), String.valueOf(now.getDayOfMonth()));
	}

	@Test
	public void TC_06_Display_Correct_Current_Year_Drop_List_In_End_Year() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(endYear.getTextDisplay(), String.valueOf(now.getYear()));
	}

	@Test
	public void TC_07_Display_Correct_Current_Month_Drop_List_In_End_Month() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(endMonth.getTextDisplay(), String.valueOf(now.getMonthValue()));
	}

	@Test
	public void TC_08_Display_Correct_Current_Day_Drop_List_In_End_Month() throws InterruptedException {
		LocalDate now = LocalDate.now();
		Assert.assertEquals(endDay.getTextDisplay(), String.valueOf(now.getDayOfMonth()));
	}

}