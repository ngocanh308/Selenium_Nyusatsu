package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.BothSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_UI_Sub_Menu extends TestHelper {

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
	public void TC_02_Title_Window_Both() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_BOTH);
	}

	@Test
	public void TC_03_HighLight_Sub_Menu_When_Click() throws InterruptedException {
		Assert.assertEquals(both.isHighlightWhenClickSubmenu(Constant.TEXT_COLOR_SUB, Constant.BACKGROUND_COLOR_SUB), true);
	}
	
	@Test
	public void TC_04_Check_Text_Sub_Menu() {
		Assert.assertEquals(both.getTextSubmenu(), Constant.TEXT_SUBMENU);
	}
	
}