package com.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	// Common page
	public static final String TEXT_SEARCH = "検索する";
	public static String folderName ="";

	// Login page
	public static final String USERNAME = "nyusatsu-king-test9@zuno.vc";
	public static final String PASSWORD = "uwg4SXX#";
	public static final String[] ARRAY_INVALID_PASSWORD = { "12345", "123456", "2345", "32145", "34354" };
	public static final String[] ARRAY_INVALID_USERNAME = { "nyusatsu@zuno.vc", "nyusat922@zuno.vc", "nyu@zuno.vc" };
	public static final String ERROR_LOGIN = "※登録したメールアドレス・パスワードをご確認ください。";
	public static final String[] LIST_USERNAME = { "nyusatsu-king-test1@zuno.vc", "nyusatsu-king-test2@zuno.vc", "nyusatsu-king-test3@zuno.vc", "nyusatsu-king-test4@zuno.vc", "nyusatsu-king-test5@zuno.vc", "nyusatsu-king-test6@zuno.vc",
			"nyusatsu-king-test7@zuno.vc", "nyusatsu-king-test8@zuno.vc", "nyusatsu-king-test9@zuno.vc", "nyusatsu-king-test10@zuno.vc" };
	public static final String[] LIST_PASSWORD = { "test0101", "TqMMJH$g", "aL4A7$@d", "YLnrA$E:", "xPSkgRNe", "eMAzMux#", "kU7B99tk", "2r&b8@zn", "uwg4SXX#", "test1010" };

	// Budget Search page
	public static final String TITLE_BUDGET = "予算書情報検索 | ［入札王］官公庁・自治体の入札・落札情報提供サービス";
	public static final String[] LIST_BUDGET_YEAR_FULL = { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" };
	public static final String[] LIST_BUDGET_YEAR_TRIAL = { "2021", "2022", "2023" };
	public static final String[] LIST_LEFT_AREA = { "中央省庁", "内閣府外郭団体", "防衛省外郭団体", "総務省外郭団体", "法務省外郭団体", "外務省外郭団体", "財務省外郭団体", "文部科学省外郭団体", "厚生労働省外郭団体", "農林水産省外郭団体", "経済産業省外郭団体", "国土交通省外郭団体", "環境省外郭団体", "警察庁外郭団体", "_都道府県庁", "市区町村", "その他" };
	public static final String[] LIST_RIGHT_3_AREA = { "独立行政法人駐留軍等労働者労務管理機構", "防衛省その他関係機関" };
	public static final String[] LIST_RIGHT_5_AREA = { "外国人技能実習機構", "日本司法支援センター(法テラス)", "法務省その他関係機関" };

	public static final String TEXT_HEAREDR_BUDGET = "予算書情報検索";
	public static final String[] TEXT_LABEL_SEARCH = { "検索期間選択", "機関選択", "検索キーワード" };
	public static final String TEXT_H3_YEAR = "検索期間選択";
	public static final String TEXT_H3_POPUP = "機関選択";
	public static final String TEXT_YEAR = "検索期間選択";
	public static final String TEXT_H3_INPUT = "検索キーワード";
	public static final String TEXT_NOTE_INPUT = "全機関の検索でのキーワード検索は時間のかかる場合があります。";
	public static final String TEXT_FAVORITE = "お気に入りを表示";
	public static final String TEXT_BUTTON = "機関選択";
	
	
	//Yotei Search
	public static final String ERROR_DOWNLOAD_CSV = "トライアル会員のお客様はダウンロード（CSV保存）できません。サンプルを作成してお渡しができますので、ご希望の方はご連絡をください。※正会員にお申し込みいただければダウンロード可能となります。";
	
	
	// Anken
	public static List<String> listIDBookMark;
	
	
	//URL_ALL_Page
	public static final String URL_HOME = "https://www.nyusatsu-king.com/";
	//public static final String URL_HOME = "http://54.250.184.6/";
	public static final String URL_BOTH = "usermenu/both_item_search/";
	public static final String URL_YOTEI = "usermenu/yotei_search/";
	public static final String URL_BUDGET = "usermenu/budget_search/";
	public static final String URL_BUDGET_TRIAL = "usermenu/guide_budget/";
	public static final String URL_YOTEIU_TRIAL = "usermenu/guide_predict/";
	public static final String URL_ANKEN = "usermenu/bookmark_anken/";
	public static final String URL_SERVICE_01 = "popup/popup_service_01/" ;
	public static final String URL_SERVICE_03 = "popup/popup_service_03/";
	public static final String URL_SERVICE_04 = "popup/popup_service_04/";
	public static final String URL_PRICE_ADDDID = "popup/price_addid/";
	public static final String URL_ERROR_404 = "error/404/";
	public static final String URL_ERROR_SESSION = "error/session/";
	public static final String URL_MENU_ABOUT = "menu/about/";
	public static final String URL_MENU_DOCUMENT = "menu/document/";
	public static final String URL_MENU_JOIN = "menu/join/";
	public static final String URL_MENU_OPTION = "menu/option/";
	public static final String URL_MENU_PRICE = "menu/price/";
	public static final String URL_MENU_CATEGORIES = "info/category/";
	public static final String URL_MENU_CONTACT = "info/contact/";
	public static final String URL_MENU_FOLOW_ENTRY ="info/flow_entry/";
	public static final String URL_LOGIN_ERROR = "info/login_error/";
	public static final String URL_NEWS_TEMP = "info/news_temp/";
	public static final String URL_PATTERN = "info/partner/";
	public static final String URL_POLICY = "info/policy/";
	public static final String URL_RULE_BOOK = "info/rulebook/"; //done
	public static final String URL_SUMMARY = "info/summary/";
	public static final String URL_TRIAL_USER = "info/trial_user/";
	public static final String URL_TRIAL_EASY = "info/flow_trial/easy/";
	public static final String URL_MAIL_FIN = "info/flow_trial/easy/mail_fin/";
	public static final String URL_DETAIL_INPUT = "info/flow_trial/easy/detail_input/";
	public static final String URL_REQUIRE_LOGIN = "user/login/";
	public static final String URL_REGIDST_INPUT = "info/regist-input";
	public static final String URL_TRIAL_RSGIST = "info/flow_trial/regular";
	public static final String URL_DO_REMIND = "do_remind";
	public static final String URL_CHANGE_MAIL = "usermenu/mail_change/";
	public static final String URL_INFOR_CHANGE = "usermenu/info_change/";
	
	// Text Page
	
}