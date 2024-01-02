package com.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.common.Button;
import com.common.DriverUtils;
import com.common.LinkText;
import com.common.Message;
import com.common.Textbox;

public class Login_Page {
	LinkText lblIconLogin = new LinkText(By.cssSelector(".nav-link--login"));
	Textbox txtUserName = new Textbox(By.id("USER_EMAIL"));
	Textbox txtPassWord = new Textbox(By.id("USER_PASSWORD"));
	Button btnLogin = new Button(By.id("button_login"));
	Message msErrorLogin = new Message(By.cssSelector(".text-muted.mb-0.login_fail"));

	private final String tabMenu = "#gnav li.authed-gnav__item:nth-child(%s) a"; // Tab menu

	LinkText lblBudget_Tab = new LinkText(By.cssSelector("#gnav li.authed-gnav__item:nth-child(1) a "));
	LinkText lblYotei_Tab = new LinkText(By.cssSelector("#gnav li.authed-gnav__item:nth-child(2) a "));
	LinkText lblBoth_Tab = new LinkText(By.cssSelector("#gnav li.authed-gnav__item:nth-child(3) a "));
	LinkText lblMail_Tab = new LinkText(By.cssSelector("#gnav li.authed-gnav__item:nth-child(4) a "));
	LinkText lblAnken_Tab = new LinkText(By.cssSelector("#gnav li.authed-gnav__item:nth-child(5) a "));

	public void login(String username, String password) throws InterruptedException {

		lblIconLogin.clickLinkText();
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}
	
	public void login_authen(String username, String password) throws InterruptedException, Exception {
		String url = DriverUtils.getDriver().getCurrentUrl().replaceAll("https://", "");
		String username1 = "zuno";
		String password1 = "g1";
		String URL = "https://" + username  + ":" + password + "@" + url;
		DriverUtils.getDriver().get(URL); // Basically operation done here itself still if not work use further Alert code as well
		Alert alert = DriverUtils.getDriver().switchTo().alert();
		alert.accept(); 
		lblIconLogin.clickLinkText();
		txtUserName.type(username);
		txtPassWord.type(password);
		btnLogin.click();
	}

	public String getErrorMessageLogin() {
		return msErrorLogin.getTextMessage();
	}

	public void clickTabMenu(String text) {
		DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabMenu, text))).click();
	}

}
