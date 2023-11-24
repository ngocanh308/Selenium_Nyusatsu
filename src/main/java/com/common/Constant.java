package com.common;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	
	//Login page
	public static final String URLHOME = "https://www.nyusatsu-king.com/";
	public static final String USERNAME = "nyusatsu-king-test9@zuno.vc";
	public static final String PASSWORD= "uwg4SXX#";
	public static final String URLBOTH = "https://www.nyusatsu-king.com/usermenu/both_item_search/";
	public static final String[] ARRAY_INVALID_PASSWORD = {"12345","123456","2345","32145","34354"}; 
	public static final String[] ARRAY_INVALID_USERNAME = {"nyusatsu@zuno.vc","nyusat922@zuno.vc","nyu@zuno.vc"};
	public static final String ERROR_LOGIN ="※登録したメールアドレス・パスワードをご確認ください。";
	public static final String[] LIST_USERNAME = {"nyusatsu-king-test1@zuno.vc","nyusatsu-king-test2@zuno.vc","nyusatsu-king-test3@zuno.vc","nyusatsu-king-test4@zuno.vc","nyusatsu-king-test5@zuno.vc","nyusatsu-king-test6@zuno.vc","nyusatsu-king-test7@zuno.vc","nyusatsu-king-test8@zuno.vc","nyusatsu-king-test9@zuno.vc","nyusatsu-king-test10@zuno.vc"};
	public static final String[] LIST_PASSWORD	= {"test0101","TqMMJH$g","aL4A7$@d","YLnrA$E:","xPSkgRNe","eMAzMux#","kU7B99tk","2r&b8@zn","uwg4SXX#","test1010"};

}