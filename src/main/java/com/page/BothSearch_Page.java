package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.DriverUtils;

public class BothSearch_Page extends Common_Page {
	String leftListArea = "#js-block__large-list ul.block__large-list li";
	

	

	
	public boolean getListLeftPopup(String[] expectList) throws InterruptedException {
		openPopupArea();
		Thread.sleep(3000);
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftListArea)));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : allOptions) {
			foo.add(item.getText());
		}
		for (int i = 0; i < foo.size(); i++) {
			if (foo.get(i).equals(expectList[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean checkRightItemPopup(int left, String[] right) {
		WebElement itemLeft = DriverUtils.getDriver().findElement(By.cssSelector("#js-block__large-list ul.block__large-list li:nth-child(" + left + ")"));
		itemLeft.click();
		String index;
		index = itemLeft.getAttribute("data-index");
		List<WebElement> list_itemRight = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div[data-index = '" + index + "']>ul>li>label>span"));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : list_itemRight) {
			foo.add(item.getText());
			for (int i = 0; i < foo.size(); i++) {
				if (foo.get(i).equals(right[i])) {
					return true;

				}
			}

		}
		return false;

	}

	public List<String> getListTextRight(int left) {
		WebElement itemLeft = DriverUtils.getDriver().findElement(By.cssSelector("#js-block__large-list ul.block__large-list li:nth-child(" + left + ")"));
		itemLeft.click();
		String index;
		index = itemLeft.getAttribute("data-index");
		List<WebElement> list_itemRight = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div[data-index = '" + index + "']>ul>li>label>span"));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : list_itemRight) {
			foo.add(item.getText());
		}
		return foo;

	}

	// UI CHECK
	// 1. Check highlight sub menu when click
	public boolean isHighlightWhenClickSubmenu(String textColor, String backgroundColor) throws InterruptedException {
		boolean isHighlight = false;
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector("section.nk-tab-menu__wrap > ul > li"));
		for (WebElement item : allOptions) {
			item.click();
			String clText = item.getCssValue("color");
			System.out.println("color text 1________________________"+clText);
			String clBack = item.getCssValue("background-color");
			System.out.println("background text 2________________________"+clBack);
			if (clText.equals(textColor) && clBack.equals(backgroundColor)) {
				isHighlight = true;
			} else {
				isHighlight = false;
			}
		}
		return isHighlight;
	}

	// 1. Check highlight sub menu when click
		public String[] getTextSubmenu() {
			List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector("section.nk-tab-menu__wrap > ul > li"));
			List<String> foo = new ArrayList<String>();
			for (WebElement item : allOptions) {
				foo.add(item.getText().replace("\n", ""));
			}
			
			return convertListToArray(foo);
		}

}
