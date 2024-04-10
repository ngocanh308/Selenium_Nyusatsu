package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_08_UI_List_Radio_Search_In_Nyusatsu_Both extends TestHelper { // 検索種別
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Check_List_Text_Checkboxs_text() throws InterruptedException {
		Assert.assertEquals(both.getTextListCheckboxTypeBid("Both_Search_In"), Constant.TEXT_ADIO_SEARCH_IN);
	}

	@Test
	public void TC_03_Check_Uncheck_List_Checkboxs_Success() throws InterruptedException {
		Assert.assertEquals(both.isSelectRadio(), true);
	}
}
