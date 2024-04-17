package com.testcase.BothSearch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_16_UI_Open_Rakusatsu_Both_Successfully extends TestHelper {
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	LinkText SubjectSearch = new LinkText(By.cssSelector("#searchResult > div:nth-child(1) a"));
	LinkText IDSearch = new LinkText(By.cssSelector("#searchResult > div:nth-child(1) span.item_id"));
	LinkText SubjectDetail = new LinkText(By.cssSelector("#click_anken div.nk-item__inner h4"));
	Label IDDetail = new Label(By.cssSelector("#click_anken span.rakusatsu_id"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Open_Correct_Item_Anken_Yotei() throws InterruptedException {
		both.clickTabSubMenu("3");
		Assert.assertEquals(both.isOpenDetailItem("Rakusatsu", SubjectSearch, IDSearch, SubjectDetail, IDDetail), true);
	}
}