package com.testcase.YoteiSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_09_UI_Add_Bookmark_Succsess extends TestHelper {// Delete All bookmark
	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[6], Constant.LIST_PASSWORD[6]);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Add_New_Bookmark_Successfully() throws InterruptedException {
		login.clickTabMenu("2");
		yotei.deleteAllBookmark();
		yotei.closeBookmark();
		yotei.addNewBookmarkYotei();
		Assert.assertEquals(yotei.isAddNewBookmark(), true);

	}

	@Test
	public void TC_03_Check_Data_Bookmark_After_Add() throws InterruptedException {
		Assert.assertEquals(yotei.isShowCorrectBookmark(), true);
	}
}