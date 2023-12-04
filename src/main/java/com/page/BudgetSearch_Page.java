package com.page;
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

public class BudgetSearch_Page {
	Button btnfavorite = new Button(By.cssSelector(".bt_favorite"));
	LinkText linkHeader = new LinkText(By.cssSelector(".ttl-type_003 a"));
	Label lblTitle_Year = new Label(By.cssSelector("//h3[text()='検索期間選択']"));
	Label lblTitle_Popup = new Label(By.cssSelector("//h3[text()='機関選択']"));
	Label lblTitle_KW = new Label(By.cssSelector("//h3[text()='検索キーワード']"));
	Listbox lbxStart_Year = new Listbox(By.cssSelector("#reg_Syear"));
	Listbox lbxEnd_Year = new Listbox(By.cssSelector("#reg_Eyear"));
	Textbox txtList_Area = new Textbox(By.cssSelector("#frmS_ORGAN_NAME"));
	Button btnpopup_Area = new Button(By.cssSelector(".search__btn--block"));
	Textbox txtKW = new Textbox(By.cssSelector("#searchValue"));
	Button btnSubmit = new Button(By.cssSelector("btn_form_submit"));
	String listYear = "//select[@name='%s']";
	String listOptionYear = "//select[@name='%s']/option";
	String actual[];

	public void selectType(String name, String value) throws InterruptedException {
		Select list = new Select(DriverUtils.getDriver().findElement(By.xpath(String.format(listYear, name))));
		list.selectByVisibleText(value);
	}

	public int sizeYear(String name) {
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.xpath(String.format(listOptionYear, name)));
		return allOptions.size();
	}
	
	public boolean validateValueListDropDown(String name,String[] expectList) {
		WebElement dropdown = DriverUtils.getDriver().findElement(By.xpath(String.format(listYear, name)));
		Select sel = new Select(dropdown);
		List<WebElement> option = sel.getOptions();
		for (int i = 0; i < option.size(); i++) {
			System.out.println("List_actual______________"+option.get(i).getText());
			System.out.println("Lisst_expect______________"+expectList[i]);
			if(option.get(i).getText().equals(expectList[i])) {
				return true;
			}
		}
		return false;
	}

}
