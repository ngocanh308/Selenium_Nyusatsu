package com.testcase.BothSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_14_UI_Add_Bookmark_Success_Both extends TestHelper {
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[6], Constant.LIST_PASSWORD[6]);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Add_New_Bookmark_Successfully() throws InterruptedException {
		login.clickTabMenu("3");
		both.deleteAllBookmark();
		both.closeBookmark();
		both.addNewBookmarkBoth();
		Assert.assertEquals(both.isAddNewBookmark(), true);

	}

	@Test
	public void TC_03_Check_Data_Bookmark_After_Add() throws InterruptedException {
		Assert.assertEquals(both.isShowCorrectBookmark("Both"), true);
	}
}