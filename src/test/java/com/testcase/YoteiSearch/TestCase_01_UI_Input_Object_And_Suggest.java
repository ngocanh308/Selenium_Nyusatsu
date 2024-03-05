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
import com.page.BothSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_UI_Input_Object_And_Suggest extends TestHelper {

	Login_Page login = new Login_Page();
	BothSearch_Page both = new BothSearch_Page();
	Yotei_Page yotei = new Yotei_Page();

	Button btnAddSubjectOR = new Button(By.id("subjectORInput")); // OR subject
	Textbox txtSubjectOR = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(1)"));
	String childsubjectOR = "#subjectORTable input.subjectOR:nth-child(";
	Button btnAddSubjectAND = new Button(By.id("subjectANDInput")); // AND subject
	Textbox txtSubjectAND = new Textbox(By.cssSelector("#subjectANDTable input.subjectAND:nth-child(1)"));
	String childsubjectAND = "#subjectANDTable input.subjectAND:nth-child(";
	Button btnAddSubjectNOT = new Button(By.id("workKindNOTInput")); // NOT subject
	Textbox txtSubjectNOT = new Textbox(By.cssSelector("#workKindNOTTable input.workKindNOT:nth-child(1)"));

	Button btnAddSuggestOR = new Button(By.id("workKindORInput")); // OR suggest
	Textbox txtSuggestOR = new Textbox(By.cssSelector("#workKindORTable input.workKindOR:nth-child(1)"));
	String childSuggestOR = "#workKindORTable input.workKindOR:nth-child(";
	String childsubjectNOT = "#workKindNOTTable input.workKindNOT:nth-child(";
	Button btnAddKWAND = new Button(By.id("workKindANDInput")); // AND suggest
	Textbox txtKWSuggestAnd = new Textbox(By.cssSelector("#workKindANDTable > input:nth-child(1)"));
	String childSuggestAND = "#workKindANDTable > input.workKindAND:nth-child(";
	Button btnAddNOT = new Button(By.id("workKindNOTInput")); // OR suggest
	Textbox txtKWSuggestNot = new Textbox(By.cssSelector("#workKindANDTable > input:nth-child(1)"));
	String childSuggestNOT = "#workKindNOTTable input.workKindNOT:nth-child(";
	Button btnOpenSugestKW = new Button(By.cssSelector(".nk-btn.yotei-search__btn--kw.js-kw-open"));
	String leftListItemSuggest = "#js-workkind-list li.workkind-item"; //popup Suggest
	String leftListSuggest = "#js-workkind-list li.workkind-item"; 
	String childLeftListSuggest = "#js-workkind-list li.workkind-item:nth-child(";
	String rightItem = "//div[@id='js-workkind-keyword-list']//div[@data-index ='";

	@Test
	public void TC_01_Open_Page_Yotei_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("2");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_YOTEI);
	}

	@Test
	public void TC_02_Title_Window_Yotei() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_YOTEI);
	}

	@Test // input subject
	public void TC_03_Input_Max_Number_Textboxs_Subjec_OR() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(20, 8, btnAddSubjectOR, childsubjectOR, 20, false, false), true);
	}

	@Test
	public void TC_04_Input_Max_Lenght_Textbox_Subject_OR() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtSubjectOR), true);
	}

	@Test
	public void TC_05_Input_Max_Number_Textboxs_Subjec_AND() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(6, 5, btnAddSubjectAND, childsubjectAND,20, true, false), true);
	}

	@Test
	public void TC_06_Input_Max_Lenght_Textbox_Subject_AND() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtSubjectAND), true);
	}

	@Test
	public void TC_07_Input_Max_Number_Textboxs_Subjec_NOT() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(20, 19, btnAddSubjectNOT, childsubjectNOT,20, false, false), true);
	}

	@Test
	public void TC_08_Input_Max_Lenght_Textbox_Subject_NOT() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtSubjectNOT), true);
	}

	@Test // input suggest
	public void TC_09_Input_Max_Number_Textboxs_KW_Suggest_OR() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(120, 58, btnAddSuggestOR, childSuggestOR,20, false, false), true);
	}

	@Test
	public void TC_10_Input_Max_Lenght_Textbox_KW_Suggest_OR() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtSuggestOR), true);
	}

	@Test
	public void TC_11_HighLight_Left_KW_Suggest_Popup_When_Click() throws InterruptedException {
		Assert.assertEquals(yotei.isHighlightWhenClickLeftItem(btnOpenSugestKW,leftListItemSuggest,Constant.TEXT_COLOR, Constant.BACKGROUND_COLOR), true);
	}

	@Test
	public void TC_12_Show_Right_Item_When_Click_Popup_Suggest_KW() throws InterruptedException {
		Assert.assertEquals(yotei.isFocusWhenClickLeftItem(leftListSuggest,childLeftListSuggest,rightItem), true);
		yotei.closePopupSuggest();
	}

	@Test
	public void TC_13_Fill_Text_Selected_Into_Textboxs_Success() throws InterruptedException {
		Assert.assertEquals(yotei.fillTextKWSuggest(), true);
	}

	@Test
	public void TC_14_Input_Max_Number_Textboxs_KW_Suggest_AND() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(6, 5, btnAddKWAND, childSuggestAND,20, true, false), true);
	}

	@Test
	public void TC_15_Input_Max_Lenght_Textbox_KW_Suggest_AND() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtKWSuggestAnd), true);
	}

	@Test
	public void TC_16_Input_Max_Textboxs_KW_Suggest_NOT() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.inputMaxNumTextbox(20, 19, btnAddNOT, childSuggestNOT, 20,false, false), true);
	}

	@Test
	public void TC_17_Input_Max_Lenght_Textbox_KW_Suggest_NOT() throws InterruptedException {
		login.clickTabMenu("2");
		Assert.assertEquals(yotei.maxLenghtTextbox20(txtKWSuggestNot), true);
	}

}