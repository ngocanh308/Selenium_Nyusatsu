package com.testcase.YoteiSearch;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.page.Yotei_Page;
import com.testcase.TestHelper;

public class TestCase_02_UI_Popup_Area extends TestHelper {
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	
	
	Button btnOpenArea = new Button(By.id("block_open_button"));
	String leftListArea = "#js-block__large-list ul.block__large-list li";
	
	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}
	
	@Test 
	public void TC_02_Check_All_Item_When_Click_Button_CheckAll() throws InterruptedException {
		both.openPopupArea();
		Assert.assertEquals(both.checkAllChecbox(), null);
	}

	@Test
	public void TC_03_UnCheck_All_Item_When_Click_Button_UncheckAll() throws InterruptedException {
		Assert.assertEquals(both.uncheckAllChecbox(), null);
	}
	
	@Test
	public void TC_04_HighLight_Left_Popup_Area_When_Click() throws InterruptedException {
		Assert.assertEquals(both.isHighlightWhenClickLeftItem(btnOpenArea,leftListArea,Constant.TEXT_COLOR, Constant.BACKGROUND_COLOR), null);
	}
	
	public void TC_05_Show_Right_Item_When_Click_Popup_Area() throws InterruptedException {
	//	Assert.assertEquals(both.isFocusWhenClick( leftListSuggest, childLeftListSuggest, rightItem), true);
	}
}