package com.testcase.BothSearch;

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

public class TestCase_11_UI_Popup_Place_Rakusatsu_Both extends TestHelper { // 発注地域
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
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Check_All_Item_When_Click_Button_CheckAll_Popup_Place() throws InterruptedException {
		both.openPopupPlaceBoth("rakusatsu");
		Assert.assertEquals(both.checkAllChkPlace(), true);
	}

	@Test
	public void TC_03_UnCheck_All_Item_When_Click_Button_UncheckAll_Popup_Place() throws InterruptedException {
		Assert.assertEquals(both.uncheckAllChkPlace(), true);
		both.closePopup("Place");
	}

	@Test
	public void TC_04_Fill_Corect_Text_Popup_Place_Into_Textbox_After_Seleted() throws InterruptedException {
		both.openPopupPlaceBoth("rakusatsu");
		Assert.assertEquals(both.isSelectedPlace("Rakusatsu"), true);
	}

}