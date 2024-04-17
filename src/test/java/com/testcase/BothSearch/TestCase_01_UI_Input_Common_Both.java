package com.testcase.BothSearch;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Textbox;
import com.page.BothSearch_Page;
import com.page.Login_Page;
import com.testcase.TestHelper;

public class TestCase_01_UI_Input_Common_Both extends TestHelper {

	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();

	Button btnAddSubjectOR = new Button(By.id("subjectORInput")); // OR subject
	String childsubjectOR = "#subjectORTable input.subjectOR:nth-child(";
	Textbox txtSubjectOR = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(1)"));
	Button btnAddSubjectAND = new Button(By.id("subjectANDInput")); // AND subject
	String childsubjectAND = "#subjectANDTable input.subjectAND:nth-child(";
	Textbox txtSubjectAND = new Textbox(By.cssSelector("#subjectANDTable input.subjectAND:nth-child(1)"));
	Button btnAddSubjectNOT = new Button(By.id("subjectNOTInput")); // NOT subject
	Textbox txtSubjectNOT = new Textbox(By.cssSelector("#subjectNOTTable input.subjectNOT:nth-child(1)"));
	String childsubjectNOT = "#subjectNOTTable input.subjectNOT:nth-child(";

	@Test
	public void TC_01_Open_Page_Budget_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(Constant.BET_TIME);
		login.clickTabMenu("3");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BOTH);
	}

	@Test
	public void TC_02_Title_Window_Both() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_BOTH);
	}

	@Test // input subject
	public void TC_03_Input_Max_Number_Textboxs_Subjec_OR() throws InterruptedException {
		login.clickTabMenu("3");
		both.clickTabSubMenu("2");
		Assert.assertEquals(both.inputMaxNumTextbox(40, 18, btnAddSubjectOR, childsubjectOR, 20, false, false), true);
	}

	@Test
	public void TC_04_Input_Max_Lenght_Textbox_Subject_OR() throws InterruptedException {
		login.clickTabMenu("3");
		both.clickTabSubMenu("2");
		Assert.assertEquals(both.maxLenghtTextbox(txtSubjectOR, Constant.TEXT_23, Constant.TEXT_20), true);
	}

	@Test
	public void TC_05_Input_Max_Number_Textboxs_Subjec_AND() throws InterruptedException {
		login.clickTabMenu("3");
		both.clickTabSubMenu("2");
		Assert.assertEquals(both.inputMaxNumTextbox(6, 5, btnAddSubjectAND, childsubjectAND, 20, true, false), true);
	}

	@Test
	public void TC_06_Input_Max_Lenght_Textbox_Subject_AND() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.maxLenghtTextbox(txtSubjectAND, Constant.TEXT_23, Constant.TEXT_20), true);
	}

	@Test
	public void TC_07_Input_Max_Number_Textboxs_Subjec_NOT() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.inputMaxNumTextbox(20, 19, btnAddSubjectNOT, childsubjectNOT, 20, false, false), true);
	}

	@Test
	public void TC_08_Input_Max_Lenght_Textbox_Subject_NOT() throws InterruptedException {
		login.clickTabMenu("3");
		Assert.assertEquals(both.maxLenghtTextbox(txtSubjectNOT, Constant.TEXT_23, Constant.TEXT_20), true);
	}
}