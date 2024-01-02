package com.page;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.LinkText;
import com.common.Textbox;
import com.common.Label;
import com.common.Listbox;

public class BudgetSearch_Page extends Common_Page {
	Button btnfavorite = new Button(By.id("bt_favorite"));
	LinkText linkHeader = new LinkText(By.cssSelector(".ttl-type_003 a"));
	Label lblTitle_Year = new Label(By.cssSelector("//h3[text()='検索期間選択']"));
	Label lblTitle_Popup = new Label(By.cssSelector("//h3[text()='機関選択']"));
	Label lblTitle_KW = new Label(By.cssSelector("//h3[text()='検索キーワード']"));
	Listbox lbxStart_Year = new Listbox(By.cssSelector("#reg_Syear"));
	Listbox lbxEnd_Year = new Listbox(By.cssSelector("#reg_Eyear"));
	Textbox txtList_Area = new Textbox(By.cssSelector("#frmS_ORGAN_NAME"));
	Button btnpopup_Area = new Button(By.cssSelector(".search__btn--block"));
	Textbox txtKW = new Textbox(By.cssSelector("#searchValue"));
	Button btnSubmit = new Button(By.id("btn_form_submit"));
	String listYear = "//select[@name='%s']";
	String listOptionYear = "//select[@name='%s']/option";
	String actual[];
	Button unFavorite = new Button(By.cssSelector("#searchResult > div:nth-child(1) > div.nk-item__title-favorite.bookmarked"));

	// List text label
	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
	String listLabelSearch = ".search__f-box-l h3";
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));
//	Label lblHearderBudget = new Label(By.cssSelector(".ttl-type_003 a"));

	public List<String> getTextLabelSearch() {
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(listLabelSearch)));
		List<String> text = new ArrayList<String>();
		for (WebElement item : allOptions) {
			text.add(item.getText());
		}
		return text;
	}

	public void selectType(String name, String value) throws InterruptedException {// Name : droplist Start (DATE_S.year) or End (DATE_E.year)
		Select list = new Select(DriverUtils.getDriver().findElement(By.xpath(String.format(listYear, name))));
		list.selectByVisibleText(value);
	}

	public int sizeYear(String name) { // Name : droplist Start (DATE_S.year) or End (DATE_E.year)
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.xpath(String.format(listOptionYear, name)));
		return allOptions.size();
	}

	public boolean validateValueListDropDown(String name, String[] expectList) {
		WebElement dropdown = DriverUtils.getDriver().findElement(By.xpath(String.format(listYear, name)));
		Select sel = new Select(dropdown);
		List<WebElement> option = sel.getOptions();
		for (int i = 0; i < option.size(); i++) {
			if (option.get(i).getText().equals(expectList[i])) {
				return true;
			}
		}
		return false;
	}

	public void searchKWBudget(String text, String yearStart, String yearEnd)throws InterruptedException
	{
		DriverUtils.getDriver().get(Constant.URL_HOME + Constant.URL_BUDGET );
		selectType("DATE_S.year",yearStart);
		selectType("DATE_E.year",yearEnd);
		txtKW.type(text);
		btnSubmit.click();		
	}
	
	public void favoriteBudget( int numberItem) { // ONLY USE FOR FUNCTION isBookmarBothkSuccess()
		int tmp = 0;
		int number;
		String text;
		List<String> temnpListIDFavorite = new ArrayList<String>();
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.xpath("//*[@id=\"searchResult\"]/div"));
		for (int i = 1; i <= listItems.size(); i++) {
			if (numberItem != 0 && tmp == numberItem) {
				break;
			}
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.no_bookmark span.bookmark-text"));
			String isBookmark = item.getAttribute("class");
			if (!isBookmark.contains("bookmarked")) { // bookmarked -> no_bookmark
				item.click();
				tmp++;
					WebElement itemID = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__inner h5.contact_no span"));
					//temnpListIDBookMark.add(itemID.getText());
					number = Integer.parseInt(itemID.getText(),10);
					text = Integer.toString(number);
					temnpListIDFavorite.add(text);

			}
		}
		if (!temnpListIDFavorite.isEmpty()) {
			Constant.listIDFavorite = temnpListIDFavorite;
		}
		
	}
	
	public boolean isFavoriteSucess() throws InterruptedException {
		btnfavorite.click();
		Thread.sleep(5000);
		// boomarkItemBoth(numItem);
		boolean isValid = false;
		List<String> listIDFavorite = new ArrayList<String>();
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.cssSelector("div#searchResult>div"));
		for (int i = 1; i < listItems.size(); i++) {
			listIDFavorite.add(DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__inner span.item_id")).getText());
			
		}
		for (int j = 0; j < listIDFavorite.size(); j++) {
			if (listIDFavorite.get(j).contains(Constant.listIDFavorite.get(j))) {
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return isValid;
	}

	public void unFavorite()
	{
		btnfavorite.click();
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.cssSelector("#searchResult > div"));
		for(int i = 1;  i<= listItems.size(); i++)
		{
			WebElement itemFavorite = DriverUtils.getDriver().findElement(By.cssSelector("#searchResult > div:nth-child(" + i + ") > div.nk-item__title-favorite.bookmarked"));
			itemFavorite.click();
		}
		

	}

	public boolean isDisplayResultBudget() throws InterruptedException {
		Thread.sleep(5000);
		WebElement result = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"searchResult\"]"));
		if (StringUtils.isNoneBlank(result.getText())) {
			return true;
		} else {
			return false;
		}
	}
}
