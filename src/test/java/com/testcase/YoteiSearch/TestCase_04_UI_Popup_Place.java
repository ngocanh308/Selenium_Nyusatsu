package com.testcase.YoteiSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_04_UI_Popup_Place extends TestHelper { // 発注地域

	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Check_All_Item_When_Click_Button_CheckAll_Popup_Place() throws InterruptedException {
		yotei.openPopupPlaceYotei();
		Assert.assertEquals(yotei.checkAllChkPlace(), true);
	}

	@Test
	public void TC_03_UnCheck_All_Item_When_Click_Button_UncheckAll_Popup_Place() throws InterruptedException {
		Assert.assertEquals(yotei.uncheckAllChkPlace(), true);
		yotei.closePopup("Place");
	}

	@Test
	public void TC_04_Fill_Corect_Text_Popup_Place_Into_Textbox_After_Seleted() throws InterruptedException {
		yotei.openPopupPlaceYotei();
		Assert.assertEquals(yotei.isSelectedPlace("Yotei"), true);
	}

}