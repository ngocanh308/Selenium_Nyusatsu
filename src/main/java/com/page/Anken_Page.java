package com.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.common.Listbox;
import com.common.Button;
import com.common.Checkbox;
import com.common.DriverUtils;

public class Anken_Page extends Common_Page {
	private final String tabMenuAnken = ".nk-tab-menu__item:nth-child(%s)"; // Tab menu Anken 1=yotei, 2= both_item, 3 = nyusatsu ,4 = raku,
	String listYear = "//select[@name='%s']";
	Listbox year = new Listbox(By.cssSelector("#frm_display_year_yotei"));
	Checkbox checkAll = new Checkbox(By.cssSelector(".all-bookmark"));
	Button delete = new Button(By.cssSelector(".nk-btn.nk-btn--del.bookmark-anken__action-btn.btn_delete_bookmark"));

	public void clickTabMenuAnken(String text) {
		DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabMenuAnken, text))).click();

	}

	public boolean isTabSelect(String text) {
		WebElement item = DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabMenuAnken, text)));
		item.click();
		String tab = item.getAttribute("class");
		if (tab.equals("nk-tab-menu__item is-active")) {
			return true;
		}
		return false;

	}

	public void selectValueYear(String value) throws InterruptedException {
		year.selectValue(value);
	}

	public void deleteAnken(String delete_year) throws InterruptedException {
		selectValueYear(delete_year);
		selectPaging("100");
		while (true) {
			if (!isVisibleResult()) {
				break;
			}
			checkAll.click();
			delete.click();	
		}

	}

}