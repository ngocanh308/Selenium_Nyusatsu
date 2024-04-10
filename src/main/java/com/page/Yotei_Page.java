package com.page;

import com.common.Checkbox;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.common.Listbox;
import com.common.Textbox;
import com.github.dockerjava.api.model.Driver;

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
	Checkbox sendMail = new Checkbox(By.xpath("//*[@id=\"yotei-mail-form\"]/div[1]/label/span"));// Mail
	Button closePopupMail = new Button(By.xpath("//*[@id=\"stopSearchNotice\"]/div/div/label"));
	Button btnNewBookmark = new Button(By.cssSelector("div#predictSearchForm a.yotei-search__submit-btn.fire_show_pop_add")); // Button new
	Button btnUpdateBookmark = new Button(By.cssSelector("div#predictSearchForm a.yotei-search__submit-btn.fire_show_pop_update")); // Button update
	LinkText leftItemSuggest = new LinkText(By.cssSelector("#js-workkind-list li.workkind-item:nth-child(3)"));;
	// FUNCTION

	// 1 SUGGEST KW
//	public void closePopupSuggestTmp() {
//		closePopupKW.click();
//	}

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




	// 4. Bookmark ( xem lai)
	public boolean isEnableButtonNewBookmark() {
		return btnUpdateBookmark.isEnable();
	}

	public boolean isDisableButtonUpdateBookmark() {
		String text = DriverUtils.getDriver().findElement(By.cssSelector("div#predictSearchForm a.yotei-search__submit-btn.fire_show_pop_update")).getAttribute("class");
		return text.matches(".+disabled");
	}

	public void addNewBookmarkYotei()
	{
		addNewBookmarkCommon("Yotei");
		openPopupSuggest();
		leftItemSuggest.clickLinkText();
		btnSelectKW.click();
		btnNewBookmark.click();
		inputNameBookmark();
	}

}