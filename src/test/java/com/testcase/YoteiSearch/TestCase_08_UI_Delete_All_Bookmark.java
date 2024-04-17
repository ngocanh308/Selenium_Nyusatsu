package com.testcase.YoteiSearch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Textbox;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_08_UI_Delete_All_Bookmark extends TestHelper {// Delete All bookmark
	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	Button btnAddMail = new Button(By.id("emailInput"));
	String childMailOR = "#emailTable input.input-email:nth-child(";
	Textbox txtMail = new Textbox(By.cssSelector(".input-email:nth-child(1)"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[6], Constant.LIST_PASSWORD[6]);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Delete_All_Bookmark_Successfully() throws InterruptedException {
		yotei.deleteAllBookmark();
		Assert.assertEquals(yotei.isDeleteAllBookmark(), true);
		yotei.closeBookmark();
	}

}