package com.testcase.LinkPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.common.Constant;
import com.common.DriverUtils;
import com.testcase.TestHelper;
import com.common.Label;
import com.common.Image;
import com.page.URLLink_AllPage;

public class TestCase_01_List_URL_Web_Page extends TestHelper {
	
	URLLink_AllPage linkPage = new URLLink_AllPage();
	
	// element
	Label price_addid = new Label(By.cssSelector(".secTit"));
	Image img_service_001 = new Image(By.xpath("//img[@alt=\"落札情報検索\"]"));
	Image img_service_003 = new Image(By.xpath("//img[@alt=\"検索結果を一括ダウンロード\"]"));
	Image img_service_004 = new Image(By.xpath("//img[@alt=\"新着案件メール\"]"));
	Label txt_Error = new Label(By.cssSelector(".txt"));
	Label txt_title_menu = new Label(By.cssSelector(".ttl-type_003.text-center"));
	Label txt_title_document = new Label(By.cssSelector("h2.ttl-type_003"));
	Label txt_title_contact = new Label(By.xpath("//*[@id=\"info\"]/div/p[2]"));
	Label txt_title_entry = new Label(By.cssSelector("div.sec-inner h2.ttl-type_003"));
	Label txt_title_category = new Label(By.cssSelector(".title-red"));	
	Label txt_title_entry2 = new Label(By.cssSelector("div.flow-entry__step h3.ttl-type_005 > span"));
	Label lbl_title_remainder = new Label(By.cssSelector(".ttl-type_003.text-center"));
			
	@Test 
	public void TC_01_Open_URL_Service_01_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_SERVICE_01);
		try {
			Assert.assertTrue(linkPage.is_Visible_IMG(img_service_001.getRuntimeElement()));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}	
	
	
	@Test
	public void TC_02_Open_URL_Service_03_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_SERVICE_03);
		try {
			Assert.assertTrue(linkPage.is_Visible_IMG(img_service_003.getRuntimeElement()));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}	
	
	
	@Test
	public void TC_03_Open_URL_Service_04_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_SERVICE_04);
		try {
			Assert.assertTrue(linkPage.is_Visible_IMG(img_service_004.getRuntimeElement()));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_04_Open_URL_Price_Addid_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_PRICE_ADDDID);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_PRICE_ADDDID));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void TC_05_Open_Text_Price_Addid_Success() throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_PRICE_ADDDID);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text(price_addid.getRuntimeElement(), "IDの追加料金表 (2ID目から)"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_06_Open_Page_Error_404_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_ERROR_404);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL( Constant.URL_HOME + Constant.URL_ERROR_404));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_07_Open_Page_Error_404_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_ERROR_404);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_Error.getRuntimeElement(), "アクセスしようとしたページは表示できませんでした。お手数ですが、トップページにお戻りいただくか、メニューよりお進みください。"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	
	@Test
	public void TC_08_Open_Page_Error_Session_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_ERROR_SESSION);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL( Constant.URL_HOME + Constant.URL_ERROR_SESSION));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_09_Open_Page_Error_Session_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_ERROR_SESSION);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_Error.getRuntimeElement(), "アクセスしようとしたページは表示できませんでした。お手数ですが、トップページにお戻りいただくか、メニューよりお進みください。"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_10_Open_Page_About_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_ABOUT);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_ABOUT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_11_Open_Page_About_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_ABOUT);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "入札王とは"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_12_Open_Page_Document_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_DOCUMENT);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_DOCUMENT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_13_Open_Page_Document_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_DOCUMENT);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_entry.getRuntimeElement(), "便利な情報取得方法"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_14_Open_Page_Join_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_JOIN);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_JOIN));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_15_Open_Page_Join_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_JOIN);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "入札に参加しよう"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_16_Open_Page_Option_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_OPTION);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_OPTION));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_17_Open_Page_Option_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_OPTION);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "お問い合わせ"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_18_Open_Page_Price_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_PRICE);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_PRICE));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_19_Open_Page_Price_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_PRICE);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "料金・お申し込み"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_20_Open_Page_Category_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_CATEGORIES);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_CATEGORIES));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_21_Open_Page_Category_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_CATEGORIES);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_category.getRuntimeElement(), "■業種カテゴリ"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_22_Open_Page_Contact_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_CONTACT);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_CONTACT));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_23_Open_Page_Contact_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_CONTACT);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_contact.getRuntimeElement(), "入札王に関するお問い合わせは下記フォームよりお問い合わせください。"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_24_Open_Page_Entry_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_FOLOW_ENTRY);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_MENU_FOLOW_ENTRY));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_25_Open_Page_Entry_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_MENU_FOLOW_ENTRY);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_entry2.getRuntimeElement(), "正会員（有料会員）お申し込みの流れ"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_26_Open_Page_Direct_Login_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_LOGIN_ERROR);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_LOGIN_ERROR));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_27_Open_Page_Direct_Login_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_LOGIN_ERROR);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "ログインのできない方へ"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_28_Open_Page_News_Temp_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_NEWS_TEMP);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_NEWS_TEMP));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_29_Open_Page_News_Temp_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_NEWS_TEMP);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "新着情報"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_30_Open_Page_Partner_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_PATTERN);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_PATTERN));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_31_Open_Page_Partner_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_PATTERN);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "提携先のご紹介"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_32_Open_Page_Policy_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_POLICY);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_POLICY));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_33_Open_Page_Polycy_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_POLICY);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "プライバシーポリシー"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	@Test
	public void TC_34_Open_Page_RuleBook_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_RULE_BOOK);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_RULE_BOOK));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_35_Open_Page_RuleBook_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_RULE_BOOK);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(txt_title_menu.getRuntimeElement(), "会員利用規約"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_36_Open_Page_Remainder_URL_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_LOGIN_REMAINDER);
		try {
			Assert.assertTrue(linkPage.is_Visible_URL(Constant.URL_HOME + Constant.URL_LOGIN_REMAINDER));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
	
	@Test
	public void TC_35_Open_Page_Remainder_Text_Success()throws InterruptedException {
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_RULE_BOOK);
		try {
			Assert.assertTrue(linkPage.is_Visible_Text_BR(lbl_title_remainder.getRuntimeElement(), "パスワードをお忘れになった方へ"));
		} catch (AbstractMethodError e) {
			Assert.fail();
		}
	}
}