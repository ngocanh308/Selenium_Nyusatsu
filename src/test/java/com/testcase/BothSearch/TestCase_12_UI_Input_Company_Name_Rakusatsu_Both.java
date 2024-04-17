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

public class TestCase_12_UI_Input_Company_Name_Rakusatsu_Both extends TestHelper {

	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	Button btnAddCompanyOR = new Button(By.id("or-companynameInput")); // OR subject
	String childCompanyOR = "#or-companynameTable input.or-companyname:nth-child(";
	Textbox txtCompanyOR = new Textbox(By.cssSelector("#or-companynameTable input.or-companyname:nth-child(1)"));
//	Button btnAddSubjectNOT = new Button(By.id("subjectNOTInput")); // NOT subject
	Textbox txtCompanyNOT = new Textbox(By.cssSelector("#not-companynameTable input.not-companyname:nth-child(1)"));
	String childsubjectNOT = "#not-companynameTable input.not-companyname:nth-child(";

	@Test
	public void TC_01_Open_Page_Budget_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test // input subject
	public void TC_02_Input_Max_Number_Textboxs_Company_OR() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.inputMaxNumTextbox(50, 16, btnAddCompanyOR, childCompanyOR, 100, false, false), true);
	}

	@Test
	public void TC_04_Input_Max_Lenght_Textbox_Company_OR() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.maxLenghtTextbox(txtCompanyOR, Constant.TEXT_110, Constant.TEXT_100), true);
	}

	@Test
	public void TC_07_Input_Max_Number_Textboxs_Subjec_NOT() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.inputMaxNumTextbox(5, 0, btnAddCompanyOR, childsubjectNOT, 100, false, false), true);
	}

	@Test
	public void TC_08_Input_Max_Lenght_Textbox_Subject_NOT() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.maxLenghtTextbox(txtCompanyNOT, Constant.TEXT_110, Constant.TEXT_100), true);
	}
}