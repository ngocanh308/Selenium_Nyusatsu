package com.testcase;

import org.testng.annotations.Test;

import com.common.Constant;
import com.page.BookTicketPage;
import com.page.HomePage;
import com.page.LoginPage;

public class TestCase_12_Errors_When_Password_Rreset_Ttoken_Blank extends TestHelper {
	HomePage homPage = new HomePage();
	LoginPage login = new LoginPage();
	BookTicketPage bookTicket = new BookTicketPage();

	@Test
	public void TC_12_Errors_When_Password_Rreset_Ttoken_Blank() {

		homPage.clickTabMenuHomePage(Constant.TAB_BOOK_TICKET);
		login.loginScroll(Constant.USERNAME, Constant.PASSWORD);
		scrollPage();
		bookTicket.selectType("Date", "1/21/2020");
		bookTicket.selectType("DepartStation", "Huế");
		bookTicket.selectType("ArriveStation", "Đà Nẵng");
		bookTicket.selectType("SeatType", "Soft bed");
	}

}
