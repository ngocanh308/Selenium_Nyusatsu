package com.testcase.BudgetSearch;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.common.DriverUtils;
import com.page.Login_Page;
import com.page.BudgetSearch_Page;
import com.testcase.TestHelper;

public class TestCase_01_UI_Page extends TestHelper {

	Login_Page login = new Login_Page();
	BudgetSearch_Page budget = new BudgetSearch_Page();

	@Test
	public void TC_01_Open_Page_Budget_Success() throws InterruptedException {
		login.login(Constant.USERNAME, Constant.PASSWORD);
		Thread.sleep(3000);
		login.clickTabMenu("1");
		Assert.assertEquals(DriverUtils.getDriver().getCurrentUrl(), Constant.URL_HOME + Constant.URL_BUDGET);
	}

	@Test
	public void TC_02_Title_Window() throws InterruptedException {
		String title = DriverUtils.getDriver().getTitle();
		Assert.assertEquals(title, Constant.TITLE_BUDGET);
	}

	@Test
	public void TC_03_Text_Header() throws InterruptedException {
		try {
			String text1 = String.join(",", budget.getTextLabelSearch()); // Change List array to List 1 string to compare
			String text2 = String.join(",", Constant.TEXT_LABEL_SEARCH); // Change array to 1 string to compare
			Assert.assertTrue(text1.equals(text2));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	@Test
	public void TC_04_List_Item_Start_Year() throws InterruptedException {
		Assert.assertEquals(budget.sizeYear("DATE_S.year") == 11, true);
	}

	@Test
	public void TC_05_List_Item_End_Year() throws InterruptedException {
		Assert.assertEquals(budget.sizeYear("DATE_E.year") == 11, true);
	}

	@Test
	public void TC_06_List_Value_Droplist_Start_Year() throws InterruptedException {
		Assert.assertEquals(budget.validateValueListDropDown("DATE_S.year", Constant.LIST_BUDGET_YEAR_FULL), true);
	}

	@Test
	public void TC_07_List_Value_Droplist_End_Year() throws InterruptedException {
		try {
			Assert.assertTrue(budget.validateValueListDropDown("DATE_E.year", Constant.LIST_BUDGET_YEAR_FULL));
		} catch (AssertionError e) {
			Assert.fail();
		}
	}

	//@Test
	public void TC_07_Check_All_Text_Label() throws InterruptedException {

	}
	
	@Test
	public void TC_08_Check_Popup_Left_Text_Menu() throws InterruptedException {
		Assert.assertEquals(budget.getLeftItem(), Constant.LEFT_ITEM);
	}
	
	
	@Test
	public void TC_09_Popup_UncheckAll_Success() throws InterruptedException {
		Assert.assertEquals(budget.uncheckAllChecbox(), true);
	}
	
	@Test
	public void TC_10_Popup_CheckAll_Success() throws InterruptedException {
		Assert.assertEquals(budget.checkAllChecbox(), true);
	}
	
	@Test
	public void TC_11_Popup_Check_Scroll_LeftMenu1() throws InterruptedException {
		Assert.assertEquals(budget.checkScroll_1(), true);
	}

	
	@Test
	public void TC_12_Popup_Check_Scroll_LeftMenu2() throws InterruptedException {
		Assert.assertEquals(budget.checkScroll_2(), true);
	}
	
	@Test
	public void TC_13_Popup_Check_Scroll_LeftMenu3() throws InterruptedException {
		Assert.assertEquals(budget.checkScroll_3(), true);
	}
	
	@Test // Display correct text into input search 機関選択 when selected leftmenu in popup
	public void TC_14_Check_Textbox_Area_Display_When_click_Menu_Left_1_In_Popup() throws InterruptedException {
		Assert.assertEquals(budget.getTextList1(), Constant.TEXT_LIST_1);
	}
	
	@Test
	public void TC_15_Check_Textbox_Area_Display_When_click_Menu_Left_2_In_Popup() throws InterruptedException {
		Assert.assertEquals(budget.getTextList2(), Constant.TEXT_LIST_2);
	}
	
	@Test
	public void TC_16_Check_Textbox_Area_Display_When_click_Menu_Left_3_In_Popup() throws InterruptedException {
		Assert.assertEquals(budget.getTextList3(), Constant.TEXT_LIST_3);
	}
}
