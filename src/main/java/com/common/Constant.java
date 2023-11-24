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
}
