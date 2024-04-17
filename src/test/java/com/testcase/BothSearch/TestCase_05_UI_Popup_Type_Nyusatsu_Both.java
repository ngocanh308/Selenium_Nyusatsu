package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_05_UI_Popup_Type_Nyusatsu_Both extends TestHelper { // 業種カテゴリ
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Check_All_Item_When_Click_Button_CheckAll_Popup_Type() throws InterruptedException {
		both.openPopupType();
		Assert.assertEquals(both.isUncheckAllChkType(), true);
	}

	@Test
	public void TC_03_UnCheck_All_Item_When_Click_Button_UncheckAll_Popup_Type() throws InterruptedException {
		Assert.assertEquals(both.isCheckAllChkType(), true);
	}

	@Test
	public void TC_04_Fill_Corect_Text_Popup_Type_Into_Textbox_After_Seleted() throws InterruptedException {
		Assert.assertEquals(both.isSelectedType(), true);
	}

	@Test
	public void TC_05_Show_Error_Message_When_No_Select_Item_Type() throws InterruptedException {
		both.openPopupType();
		Assert.assertEquals(both.getTextErorPopupType(), Constant.ERROR_MESSAGE_PLACE);
	}

	@Test
	public void TC_06_Show_Correct_Text_When_Select_All_Item_Type() throws InterruptedException {
		both.closePopup("Choose");
		Assert.assertEquals(both.getTextSelectAll(), Constant.TEXT_ALL_TYPE);
	}
}
