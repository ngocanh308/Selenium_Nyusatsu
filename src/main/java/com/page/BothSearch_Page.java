package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.common.Listbox;
import com.common.Textbox;

public class BothSearch_Page extends Common_Page {
	String leftListArea = "#js-block__large-list ul.block__large-list li";
	private final String tabSubMenu = "#searchForm li.nk-tab-menu__item:nth-child(%s)"; 
	
	Button btnOpenPopupType = new Button(By.cssSelector(".both-item-search__category label.nk-btn.both-item-search__btn--category")); // popup type 業種カテゴリ
	Button btnClosePopupType = new Button(By.xpath("//*[@id=\"dataSearch\"] //label[@for=\"js-category\"]")); 
	Button btnUncheckAllType= new Button(By.id("js-category-off")); 
	Button btnCheckAllType= new Button(By.id("js-category-on")); 
	Button btnSelecteType= new Button(By.cssSelector("a#js-category-btn>span.nk-btn-inner")); 
	Textbox txtType = new Textbox(By.id("frmM_CATEGORY_NAME"));
	Label lblErrorMessage = new Label(By.cssSelector("p.condition__text-result.flex-warn > span"));
	Button btnCurrentDate = new Button(By.id("open_date_enable"));
	Button btnNewBookmark = new Button(By.cssSelector("div.both-item-search__inner a.both-item-search__submit-btn.fire_show_pop_add")); // Button new
	LinkText txtSubject0 = new LinkText(By.cssSelector("#searchResult > div:nth-child(1) h4"));
	
	public void clickTabSubMenu(String text) throws InterruptedException {
		DriverUtils.getDriver().findElement(By.cssSelector(String.format(tabSubMenu, text))).click();
		Thread.sleep(Constant.MIN_TIME);
	}
	
	public boolean getListLeftPopup(String[] expectList) throws InterruptedException {
		boolean result = true;
		openPopupArea();
		Thread.sleep(Constant.BET_TIME);
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftListArea)));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : allOptions) {
			foo.add(item.getText());
		}
		for (int i = 0; i < foo.size(); i++) {
			if (!foo.get(i).equals(expectList[i])) {
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean checkRightItemPopup(int left, String[] right) {
		boolean result = true;
		WebElement itemLeft = DriverUtils.getDriver().findElement(By.cssSelector("#js-block__large-list ul.block__large-list li:nth-child(" + left + ")"));
		itemLeft.click();
		String index;
		index = itemLeft.getAttribute("data-index");
		List<WebElement> list_itemRight = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div[data-index = '" + index + "']>ul>li>label>span"));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : list_itemRight) {
			foo.add(item.getText());
			for (int i = 0; i < foo.size(); i++) {
				if (!foo.get(i).equals(right[i])) {
					result = false;
					break;

				}
			}

		}
		return result;

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
			String clBack = item.getCssValue("background-color");
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
		
	// Popup Type 業種カテゴリ
		public void openPopupType()
		{
			btnOpenPopupType.click();
		}
		
//		public void closePopupTypeTTmp()
//		{
//			btnClosePopupType.click();
//		}
		
		public boolean isUncheckAllChkType() {
			boolean isCheck = true;
			btnUncheckAllType.click();
			List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector("#js-category-list  input[type='checkbox']"));
			for (int i = 0; i < checkboxs.size(); i++) {
				if (checkboxs.get(i).isSelected()) {
					isCheck =  false;
				}
			}
			return isCheck;
		}
		
		public boolean isCheckAllChkType() {
			boolean isCheck = true;
			btnCheckAllType.click();
			List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector("#js-category-list  input[type='checkbox']"));
			for (int i = 0; i < checkboxs.size(); i++) {
				if (!checkboxs.get(i).isSelected()) {
					isCheck = false;
					break;
				}
			}
			return isCheck;
		}
		
		public boolean isSelectedType()
		{
			boolean result = true;
			List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector("#js-category-list li")); // number row = 49
			for (int i = 1; i <= allOptions.size(); i++) {
				if(i>1)
				{
					openPopupType();
				}
				btnUncheckAllType.click();
				WebElement element = DriverUtils.getDriver().findElement(By.cssSelector("#js-category-list  li:nth-child("+i+") span"));
				element.click();
				String expectText = element.getText();
				btnSelecteType.click();
				String actualText = txtType.getTextValue("value");
				if(!expectText.equals(actualText))
				{
					result = false;
					break;
				}
			}
			return result;
			
		}

		public String getTextErorPopupType()
		{
			btnUncheckAllType.click();
			btnSelecteType.click();
			return lblErrorMessage.getTextLabel();
			
		}
		
		public String getTextSelectAll()
		{
			btnCheckAllType.click();
			btnSelecteType.click();
			return txtType.getTextValue("value");
			
		}
		
		// Radio search in 検索種別 ( subject or body)
		public boolean isSelectRadio()
		{
			boolean result = true;
			List<WebElement> listRadio= DriverUtils.getDriver().findElements(By.xpath("//div[@class='both-item-search__kw-type']"));
			for (int i = 1; i <= listRadio.size(); i++) {
				WebElement itemLabel = DriverUtils.getDriver().findElement(By.xpath("//div[@class='both-item-search__kw-type']//label["+i+"]//span"));
				itemLabel.click();
				WebElement itemInput = DriverUtils.getDriver().findElement(By.xpath("//div[@class='both-item-search__kw-type']//label["+i+"]//input"));
				if(!itemInput.isSelected())
				{
					result = false; 
				}
			}
			return result;
		}
		
		
		// Droplist year/month/date  入札日（締切日）
		public void clickCurrentDate()
		{
			btnCurrentDate.click();
		}

		// Add bookmark Both
		public void addNewBookmarkBoth()
		{
			addNewBookmarkCommon("Both");
			btnNewBookmark.click();
			inputNameBookmark();
		}
		
		
		public  String getTextSearchBoth() {
			String expectText = "";
			btnSearch.click();
			expectText = txtSubject0.getTextLink().substring(0, 2);
			System.out.println("Text search_______________"+expectText);
			return expectText;
		}
		

}
