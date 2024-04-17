package com.testcase.YoteiSearch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_10_UI_Open_Yotei_Detail_Successfully extends TestHelper {// Open Detail Yotei
	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	LinkText SubjectSearch = new LinkText(By.cssSelector("#data_row0"));
	LinkText IDSearch = new LinkText(By.cssSelector("#searchResult > div:nth-child(1) span.nk-item__status-no"));
	LinkText SubjectDetail = new LinkText(By.cssSelector("#yotei-detail > div > h4"));
	Label IDDetail = new Label(By.cssSelector("#yotei-detail input.anken_id"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Open_Correct_Item_Anken_Yotei() throws InterruptedException {
		Assert.assertEquals(yotei.isOpenDetailItem("Yotei", SubjectSearch, IDSearch, SubjectDetail, IDDetail), true);
	}

}