package com.common;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	
	//Login page
	public static final String URLHOME = "https://www.nyusatsu-king.com/";
	public static final String USERNAME = "nyusatsu-king-test9@zuno.vc";
	public static final String PASSWORD= "uwg4SXX#";
	public static final String[] ARRAY_INVALID_PASSWORD = {"12345","123456","2345","32145","34354"}; 
	public static final String[] ARRAY_INVALID_USERNAME = {"nyusatsu@zuno.vc","nyusat922@zuno.vc","nyu@zuno.vc"};
	public static final String ERROR_LOGIN ="※登録したメールアドレス・パスワードをご確認ください。";
	public static final String[] LIST_USERNAME = {"nyusatsu-king-test1@zuno.vc","nyusatsu-king-test2@zuno.vc","nyusatsu-king-test3@zuno.vc","nyusatsu-king-test4@zuno.vc","nyusatsu-king-test5@zuno.vc","nyusatsu-king-test6@zuno.vc","nyusatsu-king-test7@zuno.vc","nyusatsu-king-test8@zuno.vc","nyusatsu-king-test9@zuno.vc","nyusatsu-king-test10@zuno.vc"};
	public static final String[] LIST_PASSWORD	= {"test0101","TqMMJH$g","aL4A7$@d","YLnrA$E:","xPSkgRNe","eMAzMux#","kU7B99tk","2r&b8@zn","uwg4SXX#","test1010"};
	
	//Tab menu
	public static final String URLBOTH = "https://www.nyusatsu-king.com/usermenu/both_item_search/";
	public static final String URLYOTEI = "https://www.nyusatsu-king.com/usermenu/yotei_search/";
	public static final String URLBUDGET = "usermenu/budget_search/";
	
	//Budget Search page

	public static final String TITLE_BUDGET = "予算書情報検索 | ［入札王］官公庁・自治体の入札・落札情報提供サービス";
	public static final String[] LIST_BUDGET_YEAR_FULL = {"2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024"};
	public static final String[] LIST_LEFT_AREA = {"中央省庁","内閣府外郭団体","防衛省外郭団体","総務省外郭団体","法務省外郭団体","外務省外郭団体","財務省外郭団体","文部科学省外郭団体","厚生労働省外郭団体","農林水産省外郭団体","経済産業省外郭団体","国土交通省外郭団体","環境省外郭団体","警察庁外郭団体","_都道府県庁","市区町村","その他"};
	public static final String[] LIST_RIGHT_3_AREA = {"独立行政法人駐留軍等労働者労務管理機構","防衛省その他関係機関"};
}	