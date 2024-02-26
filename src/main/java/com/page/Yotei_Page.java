package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.DriverUtils;
import com.common.Listbox;
import com.common.Textbox;

public class Yotei_Page extends Common_Page {
	// HomeSearch
	Button openPopupKW = new Button(By.cssSelector(".nk-btn.yotei-search__btn--kw.js-kw-open"));
	Button btnAddKWAND = new Button(By.id("workKindANDInput"));
	String leftList = "#js-workkind-list li.workkind-item"; // popup KW sugest
	Button btnSelectKW = new Button(By.id("js-kw-btn"));
	Button closePopupKW = new Button(By.xpath("//label[@class='nk-modal__close js-modal-close'][@for='js-kw']"));
	Listbox startYear = new Listbox(By.id("reg_Syear")); // List Year
	Listbox startMonth = new Listbox(By.id("reg_Smonth"));
	Listbox endYear = new Listbox(By.id("reg_Eyear"));
	Listbox endMonth = new Listbox(By.id("reg_Emonth"));

	// FUNCTION
	// 1 SUGGEST KW
	public void closePopupSuggest() {
		closePopupKW.click();
	}

	public void openPopupSuggest() {
		openPopupKW.click();
	}

	// Check Fill text KW suggest into Textbox
	public boolean fillTextKWSuggest() throws InterruptedException {
		boolean is_fill = false;
		Thread.sleep(500);
		openPopupSuggest();
		Thread.sleep(2000);
		List<WebElement> all_Leftitem = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftList)));
		for (int i = 2; i <= all_Leftitem.size(); i++) {
			if (i > 2 && i != 19) {
				is_fill = false;
				openPopupSuggest();
//				System.out.println("Click button popup_____________"+i);
			}
			List<String> foo = new ArrayList<String>();
			WebElement leftItem = DriverUtils.getDriver().findElement(By.cssSelector("#js-workkind-list li.workkind-item:nth-child(" + i + ")"));
			Thread.sleep(1000);
			scrollElementToTop(leftItem);
			leftItem.click();
			String index = leftItem.getAttribute("data-index");
			List<WebElement> rightItem = DriverUtils.getDriver().findElements(By.xpath("//div[@id='js-workkind-keyword-list']//div[@data-index ='" + index + "']//li"));
//			System.out.println("Left item = "+i+"____right list="+rightItem.size());
			if (rightItem.size() > 0) {
				for (int j = 0; j < rightItem.size(); j++) {
					foo.add(rightItem.get(j).getText());
//					System.out.println("left text popup________"+foo.get(j));
				}

				btnSelectKW.click();
//				System.out.println("Click button Search____________"+i);
				List<String> textSelected = new ArrayList<String>();
				for (int x = 0; x < rightItem.size(); x++) {
					WebElement textbox = DriverUtils.getDriver().findElement(By.cssSelector("#workKindORTable input.workKindOR:nth-child(" + (x + 1) + ")"));
					textSelected.add(textbox.getAttribute("value"));
//					System.out.println("text_box list______________"+textSelected.get(x));
					if (textSelected.get(x).equals(foo.get(x)))
						is_fill = true;
					else
						is_fill = false;
				}
			} else {
				continue;
			}
		}
		return is_fill;
	}

 //  2. popup Place  発注地域選択


}