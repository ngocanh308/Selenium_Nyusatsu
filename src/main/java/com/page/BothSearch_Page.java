package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.DriverUtils;

public class BothSearch_Page extends Common_Page {
	Button btnArea = new Button(By.id("block_open_button"));
	String leftList = "#js-block__large-list ul.block__large-list li";
	Button allCheckboxsOFF = new Button(By.id("js-block-off"));
	Button allCheckboxsON = new Button(By.id("js-block-on"));

	public boolean getListLeftPopup(String[] expectList) throws InterruptedException {
		btnArea.click();
		Thread.sleep(3000);
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftList)));
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

	public boolean checkAllChecbox() {
		allCheckboxsOFF.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div>ul>li>label>input.js-block-m-check"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (!checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}

	public boolean uncheckAllChecbox() {
		allCheckboxsON.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div>ul>li>label>input.js-block-m-check"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}
}
