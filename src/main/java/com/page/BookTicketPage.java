package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.common.DriverUtils;
import com.common.Form;
import com.common.Listbox;

public class BookTicketPage {

	// locator
	Form frTicket = new Form(By.xpath("//span[contains(text(),'Book ticket')]"));
	Listbox lbDate = new Listbox(By.xpath("//select[@name='Date']"));
	Listbox lbFrom = new Listbox(By.xpath("//select[@name='DepartStation']"));
	Listbox lbArrive = new Listbox(By.xpath("//select[@name='ArriveStation']"));
	Listbox lbSeatType = new Listbox(By.xpath("//select[@name='ArriveStation']"));
	Listbox lbSmount = new Listbox(By.xpath("//select[@name='TicketAmount']"));
	String listSelect = "//select[@name='%s']";

	// Method
	public boolean isFormTicketDisplay() {
		return frTicket.isDisplay();
	}

	// public void bookTicket(int dpDate, String dpFrom, String arr, String
	// typeSeat, int amount) {
	public void bookTicket(String dpDate, String dpFrom, String arr, String seat, String smount) {
		lbDate.selectVisibleText(dpDate);
		lbFrom.selectVisibleText(dpFrom);
	}

	public void selectType(String name, String value) {
		// Select listSelect = new
		// Select(DriverUtils.getDriver().findElementBy.xpath(String.format(listSelect,name)));
		Select list = new Select(DriverUtils.getDriver().findElement(By.xpath(String.format(listSelect, name))));
		list.selectByVisibleText(value);
	}

}
