package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.common.Listbox;
import com.common.Button;
import com.common.Checkbox;
import com.common.DriverUtils;

public class Anken_Page extends Common_Page {
	private final String tabMenuAnken = ".nk-tab-menu__item:nth-child(%s)"; // Tab menu Anken 1=yotei, 2= both_item, 3 = nyusatsu ,4 = raku,
	String listYear = "//select[@name='%s']";
	Listbox yearYotei = new Listbox(By.cssSelector("#frm_display_year_yotei"));
	Listbox yearBoth = new Listbox(By.cssSelector("#frm_display_year"));
	Checkbox checkAll = new Checkbox(By.xpath("//div[@class=\"bookmark-anken__action\"]/div/div/label[@class=\"all-bookmark\"]"));
	Button delete = new Button(By.cssSelector(".nk-btn.nk-btn--del.bookmark-anken__action-btn.btn_delete_bookmark"));
	Button downloadCSV = new Button(By.xpath("//a[@class=\"nk-btn nk-btn--csv bookmark-anken__action-btn export_csv\"]"));

	public void clickTabMenuAnken(String text) { // Click tab Anken 1=Yotei, 2=Both, 3=Nyu, 4=Raku
		DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabMenuAnken, text))).click();

	}

	public boolean isTabSelect(String text) { // check highlight sub-tab Anken when select
		WebElement item = DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabMenuAnken, text)));
		item.click();
		String tab = item.getAttribute("class");
		if (tab.equals("nk-tab-menu__item is-active")) {
			return true;
		}
		return false;

	}

	public void selectValueYearYotei(String value) throws InterruptedException {
		yearYotei.selectValue(value);
	}

	public void selectValueYearBoth(String value) throws InterruptedException { // 1= 2023-2022
		yearBoth.selectIndex(0);
	}

	public void deleteAnken(String delete_year) throws InterruptedException {
		selectPaging("100");
		while (true) {
			if (!isDisplayResult()) {
				break;
			} else {
				checkAll.click();
				delete.click();
				Thread.sleep(2000);
			}
		}

	}

	public void downloadAnken() throws InterruptedException {
		if (isDisplayResult()) {
			downloadCSV.click();
		}
	}

}