package com.common;

import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	// Home page
	public static final String TAB_LOGIN = "Login";
	public static final String TAB_BOOK_TICKET = "Book ticket";
	public static final String TAB_CONTACT = "Contact";
	public static final String TAB_LOGOUT = "Log out";
	public static final String TAB_REGISTER = "Register";
	public static final String TAB_CHANGE_PASSWORD = "Change password";
	public static final String HOMEURL = "http://www.railwayseleium.somee.com/Page/HomePage.cshtml";
	// Login page
	public static final String RAILWAYURL = "http://www.railwayseleium.somee.com/Page/HomePage.cshtml";
	public static final String USERNAME = "anh.ngoc.le@logigear.com";
	public static final String PASSWORD = "12345678";
	public static final String USERNAME_REGISTER = "lethingocanh308@gmail.com";
	public static final String PASSWOD_REGISTER = "12345679";
	public static final String PID = "11111anhgfgf";
	public static final String WELCOM_MESSAGE = "Welcome to Safe Railway";
	public static final String LOGINURL = "http://www.railwayseleium.somee.com/Account/Login.cshtml";
	public static final String ERROR_BLANK_PASSWORD = "There was a problem with your login and/or errors exist in your form.";
	public static final String ERROR_INVALID_PASSWORD = "Invalid username or password. Please try again.";
	public static final String[] ARRAY_INVALID_PASSWORD = { "12345", "123456", "2345", "32145", "34354" };
	// Register Page
	public static final String ERROR_EMAIL_IN_USE = "This email address is already in use.";
	public static final String MESSAGE_REGISTER_SUCESS = "Thank you for registering your account";
	public static final String ERROR_MESSAGE_REGISTER = "There're errors in the form. Please correct the errors and try again.";
	// Change pass Page
	public static final String NEW_PASSWORD = "a123:\"/{}!@$";
	public static final String CONFIRM_PASSWORD = "b456:\"/{}!@$";
	// Forgot password
	public static String URL_OUT_LOOK = "dnmail.logigear.com";

}
