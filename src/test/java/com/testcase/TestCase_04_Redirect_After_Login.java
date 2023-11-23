package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.common.Constant;
import com.page.BookTicketPage;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_04_Redirect_After_Login extends TestHelper {
	HomePage homePage = new HomePage();
	LoginPage login = new LoginPage();
	BookTicketPage bookTicket = new BookTicketPage();

	@Test
	public void TC_04_Redirect_After_Login() throws InterruptedException {

		homePage.clickTabMenuHomePage(Constant.TAB_BOOK_TICKET);
		if (login.isFormLoginDisplay()) {
			login.login(Constant.USERNAME, Constant.PASSWORD);
		} else {
			System.out.println("Form Login no display");
		}
		Assert.assertTrue(homePage.isTabDisplay(Constant.TAB_BOOK_TICKET));
	}

}
