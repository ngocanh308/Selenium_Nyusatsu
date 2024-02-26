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

public class TestCase_02_UI_Popup_Area extends TestHelper { //発注機関選択
	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();
	Yotei_Page yotei = new Yotei_Page();
	
	
	Button btnOpenArea = new Button(By.id("block_open_button"));
	String leftListArea = "#js-block__large-list ul.block__large-list li";
	String itemLeftArea = "#js-block__large-list li:nth-child(";
	String itemRightArea = "//*[@id=\"js-block__medium-list\"]/div[@data-index='";
	
	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}
	
	@Test 
	public void TC_02_Check_All_Item_When_Click_Button_CheckAll_Popup_Area() throws InterruptedException {
		both.openPopupArea();
		Assert.assertEquals(yotei.checkAllChecbox(), true);
	}

	@Test
	public void TC_03_UnCheck_All_Item_When_Click_Button_UncheckAll_Popup_Area() throws InterruptedException {
		Assert.assertEquals(yotei.uncheckAllChecbox(), true);
		both.closePopupArea();
	}
	
	@Test
	public void TC_04_HighLight_Left_Popup_Area_When_Click() throws InterruptedException {
		Assert.assertEquals(yotei.isHighlightWhenClickLeftItem(btnOpenArea,leftListArea,Constant.TEXT_COLOR, Constant.BACKGROUND_COLOR), true);
	}
	
	@Test	
	public void TC_05_Show_Right_Item_When_Click_Popup_Area() throws InterruptedException {
		Assert.assertEquals(yotei.isFocusWhenClickLeftItem( leftListArea, itemLeftArea, itemRightArea), true);
	}
	
	@Test	
	public void TC_06_Check_Each_Right_Item_When_Click_Button_At_Right_List_Popup_Area() throws InterruptedException {
		Assert.assertEquals(yotei.isCheckUncheckListItemPopupArea(leftListArea, itemLeftArea, itemRightArea), true);
	}
}