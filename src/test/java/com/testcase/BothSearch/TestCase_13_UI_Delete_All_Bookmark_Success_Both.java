package com.testcase.BothSearch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Textbox;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_13_UI_Delete_All_Bookmark_Success_Both extends TestHelper {

	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	Button btnAddMail = new Button(By.id("emailInput"));
	String childMailOR = "#emailTable input.input-email:nth-child(";
	Textbox txtMail = new Textbox(By.cssSelector(".input-email:nth-child(1)"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.LIST_USERNAME[1], Constant.LIST_PASSWORD[1]);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Delete_All_Bookmark_Successfully() throws InterruptedException {
		both.deleteAllBookmark();
		Assert.assertEquals(both.isDeleteAllBookmark(), true);
		both.closeBookmark();
	}
}