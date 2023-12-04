package com.page;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.common.Button;
import com.common.DriverUtils;
import com.common.LinkText;
import com.common.Textbox;
import com.common.Label;
import com.common.Listbox;

public class BothSearch_Page {
	Button btnArea = new Button(By.id("block_open_button"));
	String leftList = "#js-block__large-list ul.block__large-list li";
	String leftListOption = "#js-block__large-list ul.block__large-list li[%s]";
	

	
	public boolean getListLeftPopup(String[] expectList) throws InterruptedException {
		btnArea.click();
		Thread.sleep(3000);
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftList)));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : allOptions) {
			foo.add(item.getText());
			System.out.println("Text_list___________" + item.getText());
		}
		System.out.println("Size___________" +foo.size());
		for (int i = 1; i < foo.size(); i++) {
			if (foo.get(i).equals(expectList[i-1])) {
				return true;
			}
		}
		return false;
	}
}
