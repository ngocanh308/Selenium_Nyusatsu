package com.testcase.YoteiSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class Testcase_05_UI_List_Checkbox_Type_Bidking extends TestHelper {// 発注地域選択
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
	public void TC_02_Check_List_Text_Checkboxs_text() throws InterruptedException {
		Assert.assertEquals(yotei.getTextListCheckboxTypeBid("Yotei_Type"), Constant.TEXT_CHECKBOXS_YOTEI);
	}

	@Test
	public void TC_03_Check_Uncheck_List_Checkboxs_Success() throws InterruptedException {
		Assert.assertEquals(yotei.ischeckUncheckListCheckbox("Yotei_Type"), true);
	}

}
