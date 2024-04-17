package com.common;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	// Common page
	public static final String TEXT_SEARCH = "検索する";
	public static String folderName ="";
	public static String folderFaile ="";
	public static String TEXT_DOWNLOAD = "令和６";
	public static int TIME_WAIT = 15000;
	public static int LONG_TIME = 5000;
	public static int SORT_TIME = 2000;
	public static int MIN_TIME = 1000;
	public static int BET_TIME = 3000;

	// Login page
	public static final String USERNAME = "nyusatsu-king-test9@zuno.vc";
//	public static final String USERNAME = "nyusatsu-king-test7@zuno.vc";
	public static final String PASSWORD = "uwg4SXX#";
//	public static final String PASSWORD = "kU7B99tk";
	public static final String[] ARRAY_INVALID_PASSWORD = { "12345", "123456", "2345", "32145", "34354" };
	public static final String[] ARRAY_INVALID_USERNAME = { "nyusatsu@zuno.vc", "nyusat922@zuno.vc", "nyu@zuno.vc" };
	public static final String ERROR_LOGIN = "※登録したメールアドレス・パスワードをご確認ください。";
	public static final String[] LIST_USERNAME = { "nyusatsu-king-test1@zuno.vc", "nyusatsu-king-test2@zuno.vc", "nyusatsu-king-test3@zuno.vc", "nyusatsu-king-test4@zuno.vc", "nyusatsu-king-test5@zuno.vc", "nyusatsu-king-test6@zuno.vc",
			"nyusatsu-king-test7@zuno.vc", "nyusatsu-king-test8@zuno.vc", "nyusatsu-king-test9@zuno.vc", "nyusatsu-king-test10@zuno.vc" };
//	public static final String[] LIST_PASSWORD = { "test0101", "TqMMJH$g", "aL4A7$@d", "YLnrA$E:", "xPSkgRNe", "eMAzMux#", "kU7B99tk", "2r&b8@zn", "uwg4SXX#", "test1010" };
	public static final String[] LIST_PASSWORD = { "3r==2jCS", "M3;Xu:g&", "Qgsb86XH", "7Ep:v4Q8", "C@nPWeb:", "CczKvQsQ", "kuK3JH=x", "2CKzyY@P", "uwg4SXX#", "q1w2e3r4" };

	//Common Search
	public static final String TEXT_23 = "まんがは、にほんのぶんかのとくちょちょうです。";
	public static final String TEXT_20 = "まんがは、にほんのぶんかのとくちょちょう";
	public static final String TEXT_110 = "まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうですが@zuno.vcにほんのぶ";
	public static final String TEXT_100 = "まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうです。まんがは、にほんのぶんかのとくちょちょうですが@zuno.vc";
	public static final String TEXT_BOOKMARK_YOTEI[] = {"あ","単","6"};
	public static final String NAME_BOOKMARK = "Bookmark Test";
	public static final List<String> LIST_TEXT_ADD_BOOKMARK_YOTEI= Arrays.asList("あ"," 単"," 独立行政法人駐留軍等労働者労務管理機構","防衛省その他関係機関"," 茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県");
	public static final List<String> LIST_TEXT_ADD_BOOKMARK_BOTH= Arrays.asList("あ"," 独立行政法人駐留軍等労働者労務管理機構","防衛省その他関係機関"," 茨城県","栃木県","群馬県","埼玉県","千葉県","東京都","神奈川県");
	public static  List<String> LIST_TEXT_ADD_BOOKMARK_UI_YOTEI ;
	public static  List<String> LIST_TEXT_ADD_BOOKMARK_UI_BOTH ;
	
	// Budget Search page
	public static final String TITLE_BUDGET = "予算書情報検索 | ［入札王］官公庁・自治体の入札・落札情報提供サービス";
	public static final String[] LIST_BUDGET_YEAR_FULL = { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" };
	public static final String[] LIST_BUDGET_YEAR_TRIAL = { "2021", "2022", "2023" };
	public static final String[] LIST_LEFT_AREA = { "中央省庁", "内閣府外郭団体", "防衛省外郭団体", "総務省外郭団体", "法務省外郭団体", "外務省外郭団体", "財務省外郭団体", "文部科学省外郭団体", "厚生労働省外郭団体", "農林水産省外郭団体", "経済産業省外郭団体", "国土交通省外郭団体", "環境省外郭団体", "警察庁外郭団体", "都道府県庁", "市区町村", "その他" };
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
	
	public static final String[] LEFT_ITEM ={"中央省庁","都道府県庁","区市町村"};
	public static final String TEXT_LIST_1 = "設定あり (51機関)";
	public static final String TEXT_LIST_2 = "設定あり (47機関)";
	public static final String TEXT_LIST_3 = "設定あり (1710機関)";
	public static final String TEXT_SEARCH_BUDGET = "anken";
	
	
	//Yotei Search
	public static final String ERROR_DOWNLOAD_CSV = "トライアル会員のお客様はダウンロード（CSV保存）できません。サンプルを作成してお渡しができますので、ご希望の方はご連絡をください。※正会員にお申し込みいただければダウンロード可能となります。";
	public static final String TITLE_YOTEI = "入札予定情報検索 | ［入札王］官公庁・自治体の入札・落札情報提供サービス"; 
	public static final String[] LEFT_KWSUGEST = {"食品","衣料・繊維製品","文房具事務用品・図書","家具・寝具・什器・備品等","厨房・給食機器及び業務","家電・カメラ・映像関連の機器・用品及び業務","事務機器及び業務",
			"通信機器・システム及び業務","情報処理機器・ソフト及び業務","工作・産業・農業・建設用機械器具類","理化学機械器具類","薬品・防疫剤等","医療用機器・システム、医療・介護用品及び業務","各種車両・船舶・航空機",
			"鉄鋼・非鉄・鋳鉄製品、コンクリート・セメント","燃料・ガス・油脂及び工事","警察・消防・防災関連の機器・システム及び業務","防衛等装備品類","デザイン・印刷・広告","調査・研究業務","翻訳・通訳・速記","運送・発送業務",
			"電力供給","電気・電源設備及び工事","電話・通信設備及び工事","空調・換気・給排水・衛生機器及び工事","エレベーター設備及び業務","建物等の維持管理（清掃・警備・受付等）","建物等の解体・撤去","廃棄物の収集・運搬・処理等",
			"建築工事","建築資材・プレハブ","内装工事","塗装・防水用品及び工事","土木工事","道路関連工事","道路等の維持管理","橋りょう関連工事","しゅんせつ（埋立）・潜かん","防音壁・しゃ音壁及び工事","水処理関連施設及び工事",
			"造園・公園等整備","設計・測量","その他の物品","その他の業務委託","ＰＦＩ（指定管理者）"};
	public static final String TEXT_COLOR = "rgba(0, 0, 0, 1)";
	public static final String BACKGROUND_COLOR = "rgba(221, 221, 221, 1)";
	public static final String NOTE_YEAR = "※2020年度分から収集を開始していますが、2019年度分も一部収集をしています";
	public static final String TEXT_CHECKBOXS = "競争・公募指名随意";
	public static final String TEXT_CHECKBOXS_YOTEI = "競争・公募指名随意不明";
	public static final String TEXT_CHECKBOXS_RANK = "ABCDE";
	public static final String TEXT_ADIO_SEARCH_IN= "件名一致検索全文一致検索";
	public static final String TEXT_PLACEHOLDER_MAIL = "(例)abc@nyusatsu-king.com";
	
	//Both Search
	public static final String TITLE_BOTH = "入札・落札情報検索 | ［入札王］官公庁・自治体の入札・落札情報提供サービス"; 
	public static final String TEXT_COLOR_SUB = "rgba(255, 255, 255, 1)";
	public static final String BACKGROUND_COLOR_SUB = "rgba(7, 120, 11, 1)";
	public static final String TEXT_SUBMENU[] = {"入札・落札同時検索（入札メール配信設定）（関連落札メール配信案件指定）","入札情報のみ検索（入札メール配信設定）（関連落札メール配信案件指定）","落札情報のみ検索"};
	public static final String ERROR_MESSAGE_PLACE = "業種カテゴリを1つ以上選択して下さい。";
	public static final String TEXT_ALL_TYPE = "全て選択中";
	public static final String TEXT_DEFAULT_BID_DATE = "指定なし";
	public static final String[] LIST_YEAR_BID_DATE = {"2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024" , "2025", "2026", "2027"};
	public static final String[] LIST_MONTH_BID_DATE = {"1", "2", "3", "4", "5", "6", "7", "8" , "9", "10", "11", "12"};
	public static final String[] LIST_DATE_BID_DATE = {"1", "2", "3", "4", "5", "6", "7", "8" , "9", "10", "11", "12", "13", "14", "15", "16", "17", "18" , "19","20", "21", "22", "23", "24", "25", "26", "27", "28" , "29", "30" , "31"};
	
	// Anken
	public static List<String> listIDBookMark;
	public static List<String> listIDFavorite;
	public static String errorDownlaodAnken = "トライアル会員のお客様はダウンロード（CSV保存）できません。サンプルを作成してお渡しができますので、ご希望の方はご連絡をください。※正会員にお申し込みいただければダウンロード可能となります。";
	
	
	//URL_ALL_Page
	public static final String URL_HOME = "https://nyusatsu-o-neo-dev-8085.zuno.vc/";
	public static final String URL_HOME_AUTHEN = "https://zuno:g1@nyusatsu-o-neo-dev-8085.zuno.vc/";
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
	public static final String URL_LOGIN_REMAINDER = "info/login_remainder/";
	public static final String URL_REGISTER_TRIAL_ACCOUNT = "info/flow_trial/easy/";
	public static final String URL_REGISTER_TRIAL_FIN = "info/flow_trial/easy/mail_fin/";

	
	// Text PagE
	public static final String SELECT_YEAR_ANKEN_YOTEI = "2025-2023";
	public static final String SELECT_YEAR_ANKEN_BOTH = "2024-2021";
	public static final String FILE_NAME_BOTH = "nyusatsu_king_2024";
	public static final String FILE_NAME_YOTEI = "nyusatsu_king_yotei_2024";
	
	// Register trial page
	public static final String TITLE_TRIAL = "10日間無料トライアルのお申し込み【入力】 | ［入札王］官公庁・自治体の入札・落札情報提供サービス";
	public static final String TEXT_HEADER_TRIAL = "無料トライアルについて";
	public static final String MESSAGE_ERROR_ALL = "ご契約担当者名を入力してください。メールアドレスを入力してください。電話番号の桁数が正しくありません。パスワードを入力してください。";
	public static final String MESSAGE_ERROR_CD = "代理店CDは10文字以下で入力してください。";
	public static final String MESSAGE_ERROR_NAME = "ご契約担当者名は50文字以下で入力してください。";
	public static final String MESSAGE_ERROR_MAIL_EXIST = "既に登録されているメールアドレスです。";
	public static final String MESSAGE_ERROR_MAIL_FORMAT = "メールアドレスが正しくありません。";
	public static final String MESSAGE_ERROR_PHONE = "電話番号の桁数が正しくありません。";
	public static final String MESSAGE_ERROR_PASSWORD = "パスワードは半角英数字と記号（@、#、$、:、;、&、=）8文字以上15文字以下で記入して下さい。";
	public static final String MESSAGE_ERROR_PASSWORD2 = "パスワードが一致しません。もう一度お試しください";
	public static final String[] TEXT_CD_INVALID_10 = {"Hello World 2024", "WELCOME WORLD 2024"};
	public static final String TEXT_CD_VALID = "Test Auto" ;
	public static final String[] TEXT_NAME_INVALID_50 = {"ご契約担当者名ご契約担当者名ご契約担当者名ご契約担当者名ご契約担当者名ごご契約担当者名ご契約担当者名ご" , "WELCOME WORLD 2024WELCOME WORLD 2024WELCOME WORLD 2"};
	public static final String TEXT_NAME_VALID_50 = "Anh tester Auto";
	public static final String[] TEXT_NAME_INVALID_MAIL = {"lethingocanh308@zuno.vc", "lethingocanh123456"};
	public static final String TEXT_PHONE1_VALID = "0988";
	public static final String[] TEXT_PHONE_INVALID = {"0988435435","hello"};
	public static final String TEXT_PHONE2_VALID = "164";
	public static final String TEXT_PHONE3_VALID = "8940";
	public static final String TEXT_PASSWORD_VALID = "Ngocanh123@";
	public static final String[] TEXT_PASSWORD_INVALID = {"123@!","ngocanh123"};
	public static  String TEXT_MAIL ;
	public static  String TEXT_HEADER_POLICY = "プライバシーポリシー" ;
}