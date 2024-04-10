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

public class TestCase_06_UI_Send_Mail extends TestHelper {// Mail 入札案件配信アドレス
	Login_Page login = new Login_Page();
	Yotei_Page yotei = new Yotei_Page();

	Button btnAddMail = new Button(By.id("emailInput"));
	String childMailOR = "#emailTable input.input-email:nth-child(";
	Textbox txtMail = new Textbox(By.cssSelector(".input-email:nth-child(1)"));

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Check_Text_PlaceHolder() throws InterruptedException {
		Assert.assertEquals(yotei.getPlaceHolder(txtMail), Constant.TEXT_PLACEHOLDER_MAIL);
	}

	@Test
	public void TC_03_Input_Max_Number_Textboxs_Mail() throws InterruptedException {
		Assert.assertEquals(yotei.inputMaxNumTextbox(100, 49, btnAddMail, childMailOR, 92, false, true), true);
	}

	@Test
	public void TC_04_Input_Max_Lenght_Textbox_Mail() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox(txtMail, Constant.TEXT_110, Constant.TEXT_100), true);
	}

	@Test
	public void TC_05_Input_Max_Lenght_Textbox_Mail() throws InterruptedException {
		Assert.assertEquals(yotei.maxLenghtTextbox(txtMail, Constant.TEXT_110, Constant.TEXT_100), true);
	}

	@Test
	public void TC_06_Show_Popup_Warning_When_Click_Checkbox_UnsendMail() throws InterruptedException {
		Assert.assertEquals(yotei.showPopupSendMail(), true);
		yotei.closePopup("Mail");
	}

}