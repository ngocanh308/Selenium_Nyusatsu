package com.page;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.Listbox;
import com.common.Message;
import com.common.Textbox;

public class Common_Page {
	Textbox txtOR = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(1)"));
	Textbox txtORList = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(%s)"));
	Textbox txtAND = new Textbox(By.cssSelector("#workKindANDTable input.workKindAND:nth-child(1)"));
	Button closeWarning = new Button(By.cssSelector("#message_modal > div > div > label"));
	Button addAND = new Button(By.id("subjectANDInput"));
	Button search = new Button(By.cssSelector("a#btn_form_submit>span.nk-btn-inner"));
	Button downloadCSV = new Button(By.id("export_csv"));
	Message msPopupError = new Message(By.cssSelector(".condition__text-result.flex-warn span"));
	Button closePopupError = new Button(By.xpath("//p[@class=\"condition__text-result flex-warn\"]/preceding::label[@for=\"js-message\"]"));
	Listbox numPage = new Listbox(By.cssSelector("#frmPagesize"));
	Label listResult = new Label(By.xpath("//*[@id=\"searchResult\"]"));

	Button allCheckboxsOFF = new Button(By.id("js-block-off"));//Popup Area
	Button allCheckboxsON = new Button(By.id("js-block-on"));
	Button checkUncheckArea = new Button(By.id("js-check-all-s-block"));
	//#js-area-list input[type='checkbox']
	Button allChkPlaceOFF = new Button(By.id("js-area-off"));
	Button allChkPlaceON = new Button(By.id("js-area-on"));
	
	Button btnOpenPopupPlace = new Button(By.cssSelector(".nk-btn.yotei-search__btn--area .nk-btn-inner")); // popup place 発注地域
	Button btnClosePopupPlace = new Button(By.cssSelector("label.nk-modal__close.js-modal-close[for='js-area']"));
	Textbox txtPlace = new Textbox(By.id("frmAREA_NAME"));
	Button btnChoosePlace = new Button(By.cssSelector(".regist-input__pref-info .nk-btn-inner"));

	// Variable public
	String defaultWindow = "";

	// I. FUNCTION DEFINE
	public void inputOR(String inputText) throws InterruptedException {
		txtOR.type(inputText);
		search.click();
	}

	public void downloadCSV(String inputText) throws InterruptedException {
		txtOR.type(inputText);
		search.click();
		Thread.sleep(2000);
		downloadCSV.click();
		Thread.sleep(2000);
	}

	public void delete_File() {
		File[] listOfFiles = new File(Constant.folderName).listFiles();
		if (listOfFiles.length > 0) {
			for (int i = 0; i < listOfFiles.length; i++) {
				listOfFiles[i].delete();
			}
		}
	}

	public boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException {
		// Array to Store List of Files in Directory
		File[] listOfFiles;

		// Store File Name
		String fileName;

		// Consider file is not downloaded
		boolean fileDownloaded = false;

		// capture time before looking for files in directory
		// last modified time of previous files will always less than start time
		// this is basically to ignore previous downloaded files
		long startTime = Instant.now().toEpochMilli();

		// Time to wait for download to finish
		long waitTime = startTime + timeOut;

		// while current time is less than wait time
		while (Instant.now().toEpochMilli() < waitTime) {
			// get all the files of the folder
			listOfFiles = new File(Constant.folderName).listFiles();

			// iterate through each file
			for (File file : listOfFiles) {
				// get the name of the current file
				fileName = file.getName().toLowerCase();

				// condition 1 - Last Modified Time > Start Time ( + 10000 vì lastModified luon
				// luon be hơn start time - Cheat)
				// condition 2 - till the time file is completely downloaded extension will be
				// crdownload
				// Condition 3 - Current File name contains expected Text
				// Condition 4 - Current File name contains expected extension
				if ((file.lastModified() + 10000) > startTime && !fileName.contains("crdownload") && fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase()))
//	            	if ( !fileName.contains("crdownload") &&   fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase())) 
				{
					// File Found
					fileDownloaded = true;
					break;
				}
			}
			// File Found Break While Loop
			if (fileDownloaded)
				break;
		}
		// File Not Found
		return fileDownloaded;
	}

	public boolean isFileAvailabel(String expectedFileName) {
		File folder = new File(Constant.folderName);
		File[] listofFiles = folder.listFiles();
		boolean isFileAvailabel = false;
		for (File listofFile : listofFiles) {
			String filename = listofFile.getName();
			if (filename.matches(expectedFileName))
				isFileAvailabel = true;
		}
		return isFileAvailabel;
	}

	public String getErrorMessagePopup() {
		return msPopupError.getTextMessage().replace("\n", "");
	}

	public void closePopup() {
		closePopupError.click();

	}

	public boolean isDisplayResult() throws InterruptedException {
		WebElement result = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"searchResult\"]"));
		if (StringUtils.isNoneBlank(result.getText())) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			DriverUtils.getDriver().findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void selectPaging(String value) throws InterruptedException {
		numPage.selectValue(value);
	}

	public boolean isBookmarkSuccess(String tab) {
		// boomarkItemBoth(numItem);
		boolean isValid = false;
		List<String> listIDAnkenBoth = new ArrayList<String>();
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.cssSelector("div#searchResult>div"));
		for (int i = 1; i <= listItems.size(); i++) {
			if (tab.equals("BOTH")) {
				listIDAnkenBoth.add(DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") span.item_id")).getText());
			} else if (tab.equals("YOTEI")) {
				listIDAnkenBoth.add(DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") span.nk-item__status-no")).getText());
			}
		}
		for (int j = 0; j < listIDAnkenBoth.size(); j++) {
			// if (listIDAnkenBoth.get(j).equals(listIDBookMark.get(j))) {
			if (listIDAnkenBoth.get(j).contains(Constant.listIDBookMark.get(j))) {
				isValid = true;
			} else {
				isValid = false;
			}
		}
		return isValid;
	}

	public void boomarkItem(String tab, int numberItem) { // ONLY USE FOR FUNCTION isBookmarBothkSuccess()
		int tmp = 0;
		List<String> temnpListIDBookMark = new ArrayList<String>();
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.xpath("//*[@id=\"searchResult\"]/div"));
		for (int i = 1; i <= listItems.size(); i++) {
			if (numberItem != 0 && tmp == numberItem) {
				break;
			}
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__title-favorite"));
			String isBookmark = item.getAttribute("class");
			if (isBookmark.contains("no_bookmark")) { // bookmarked -> no_bookmark
				item.click();
				tmp++;
				if (tab.equals("BOTH")) {
					WebElement itemID = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__status-area span.item_id"));
					temnpListIDBookMark.add(itemID.getText());
				} else if (tab.equals("YOTEI")) {
					WebElement itemID = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__status-area span.nk-item__status-no"));
					temnpListIDBookMark.add(itemID.getText());
				}

			}
		}
		if (!temnpListIDBookMark.isEmpty()) {
			Constant.listIDBookMark = temnpListIDBookMark;
		}

	}

	public void boomarkItem(int numberItem) {
		int tmp = 0;
		List<WebElement> listItems = DriverUtils.getDriver().findElements(By.xpath("//*[@id=\"searchResult\"]/div"));
		for (int i = 1; i <= listItems.size(); i++) {
			if (numberItem != 0 && tmp == numberItem) {
				break;
			}
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("div#searchResult>div:nth-child(" + i + ") div.nk-item__title-favorite"));
			String isBookmark = item.getAttribute("class");
			if (isBookmark.contains("no_bookmark")) { // bookmarked -> no_bookmark
				item.click();
				tmp++;
			}
		}

	}

	public void scrollToTop(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scrollElementToTop(WebElement element) {
		((JavascriptExecutor) DriverUtils.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElementTop(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverUtils.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scrollToElementTop1(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverUtils.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(false);", element);
	}
	
	public boolean is_Visible_IMG(WebElement img) {
		boolean foo = false;
		Boolean is_visibleIMG = (Boolean) ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img);
		if (is_visibleIMG) {
			foo = true;
		} else {
			foo = false;
		}
		return foo;
	}

	public static boolean isVisibleInViewport(WebElement element) {

		return (Boolean) ((JavascriptExecutor) DriverUtils.getDriver()).executeScript("var elem = arguments[0],                 " + "  box = elem.getBoundingClientRect(),    " + "  cx = box.left + box.width / 2,         "
				+ "  cy = box.top + box.height / 2,         " + "  e = document.elementFromPoint(cx, cy); " + "for (; e; e = e.parentElement) {         " + "  if (e === elem)                        "
				+ "    return true;                         " + "}                                        " + "return false;                            ", element);
	}

	public void openDialog(WebElement element) {
		element.click();
		defaultWindow = DriverUtils.getDriver().getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(DriverUtils.getDriver().getWindowHandles());
		tabs.remove(defaultWindow);
		DriverUtils.getDriver().switchTo().window(tabs.get(0));

	}

	public String[] convertListToArray(List<String> names) {
		String[] namesArray = names.toArray(new String[0]);
		return namesArray;
	}

	public String convertListToString(List<String> names) {
		String namesArray = names.toString();
		return namesArray;
	}
	// II. UI DEFINE
	//1. Alert
	public boolean isAlertPresent() {
		try {
			DriverUtils.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	// Text Placehoder element
	public String getPlaceHolder (Textbox element)
	{
		String text = element.getAttribute("placeholder");		
		return text;
	}
	

	// 2. TEXTBOX check input max number textbox define
	public boolean inputMaxNumTextbox(int maxTextbox, int maxAdd, Button btnAdd, String txtFind, int maxlenghText, boolean popup, boolean mail) throws InterruptedException {
		boolean isInput = false;
		for (int j = 1; j <= maxAdd; j++) {
			btnAdd.click();
		}
		List<String> text_input = new ArrayList<String>();
		List<String> text_get = new ArrayList<String>();
		for (int i = 1; i <= maxTextbox; i++) {
			WebElement textbox = DriverUtils.getDriver().findElement(By.cssSelector(txtFind + i + ")"));

			String uuid = UUID.randomUUID().toString();
			if(mail== true)
			{
				uuid = uuid.substring(0, Math.min(uuid.length(), maxlenghText)) + "@zuno.vc";
			}
			else
			{
				uuid = uuid.substring(0, Math.min(uuid.length(), maxlenghText));
			}
			
			text_input.add(uuid);
			if (popup == true && i == 2) {
				textbox.click();
				Thread.sleep(1000);
				closeWarning.click();
			}

			textbox.sendKeys(text_input.get(i - 1));

			text_get.add(textbox.getAttribute("value"));
		}

		if (text_get.equals(text_input))
			isInput = true;
		else
			isInput = false;
		return isInput;

	}

	// 3. Textbox: Check max lenght 1 textbox 
	public boolean maxLenghtTextbox20(Textbox txt) throws InterruptedException {
		boolean isMax = false;
		txt.type(Constant.TEXT_23);
		String text = txt.getAttribute("value");
		if (text.equals(Constant.TEXT_20))
			isMax = true;
		else
			isMax = false;
		return isMax;
	}
	
	public boolean maxLenghtTextbox100(Textbox txt) throws InterruptedException {
		boolean isMax = false;
		txt.type(Constant.TEXT_110);
		String text = txt.getAttribute("value");
		if (text.equals(Constant.TEXT_100))
			isMax = true;
		else
			isMax = false;
		return isMax;
	}
	
	//POPUP AREA 発注機関選択
	//1. Highlight leftItem when click
	public boolean isHighlightWhenClickLeftItem(Button popup, String leftItem, String textColor, String backgroundColor) throws InterruptedException {
		popup.click();
		Thread.sleep(1000);
		boolean isHighlight = false;
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(leftItem)));
		List<String> foo = new ArrayList<String>();
		for (WebElement item : allOptions) {
			foo.add(item.getText());
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

	//2. Focus correct RightItem when click leftItem in popup
	public boolean isFocusWhenClickLeftItem(String listLeft, String itemLeft, String itemRight) throws InterruptedException {
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(listLeft)));
		List<String> foo = new ArrayList<String>();
		boolean isShow = false;
		for (int i = 2; i <= allOptions.size(); i++) {
			WebElement leftItem = DriverUtils.getDriver().findElement(By.cssSelector(itemLeft + i + ")"));
			foo.add(leftItem.getText());
			leftItem.click();
			String index = leftItem.getAttribute("data-index");
			WebElement rightItem = DriverUtils.getDriver().findElement(By.xpath(itemRight + index + "']"));
			String show = rightItem.getAttribute("class");

			if (show.contains("none-display")) {
				isShow = false;
			} else {
				isShow = true;
			}
		}
		return isShow;
	}


	//3 Check_Uncheck right item when select 1 left item in popup Area (ONLY EXIST AREA POPUP)
	public boolean isCheckUncheckListItemPopupArea(String listLeft, String itemLeft, String itemRight) throws InterruptedException {
		allCheckboxsOFF.click();
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(listLeft)));
		List<String> foo = new ArrayList<String>();
		boolean ischeck = false;
		for (int i = 2; i <= allOptions.size(); i++) {
			WebElement leftItem = DriverUtils.getDriver().findElement(By.cssSelector(itemLeft + i + ")"));
			foo.add(leftItem.getText());
			String textItem = leftItem.getText()+"全てを選択";
			leftItem.click();
			String index = leftItem.getAttribute("data-index");
			Thread.sleep(300);
			if (i > 2 && i != 19)
			{
				String textButton = checkUncheckArea.getTextButton();
				if(textItem.equals(textButton))
				{
					checkUncheckArea.click();
					List<WebElement> rightCheckbox = DriverUtils.getDriver().findElements(By.xpath(itemRight + index + "']//input[@class='js-block-m-check']"));
					for (int j = 0; j < rightCheckbox.size(); j++) {
						if (rightCheckbox.get(j).isSelected()) {
							ischeck = true;
						}
						else
						{
							ischeck = false;
						}
					}			
				}
			}
			else
			{
				continue;
			}
		}
		return ischeck;
		}
	
	public boolean uncheckAllChecbox() {
		allCheckboxsOFF.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div>ul>li>label>input.js-block-m-check"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (!checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}

	public boolean checkAllChecbox() {
		allCheckboxsON.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector(".block__medium div>ul>li>label>input.js-block-m-check"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}

	// Header page 
	public boolean clickHeaderMenu(int numItem, String expectURLNavigate)
	{
			boolean correctURL = false;
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("#global > ul > li:nth-child("+numItem+") > a"));
			item.click();
			String currentURL = DriverUtils.getDriver().getCurrentUrl();
			if(currentURL.equals(expectURLNavigate))
			{
				correctURL = true;
				DriverUtils.getDriver().navigate(). back();
				
			}
			else
			{
				correctURL = false;
			}
			return correctURL;
		
	}
	
	//POPUP PLACE 発注地域
	public void openPopupPlace()
	{
		btnOpenPopupPlace.click();
	}
	
	public void closePopupPlace()
	{
		btnClosePopupPlace.click();
	}
	public boolean uncheckAllChkPlace() {
		allChkPlaceOFF.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector("#js-area-list input[type='checkbox']"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (!checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkAllChkPlace() {
		allChkPlaceON.click();
		List<WebElement> checkboxs = DriverUtils.getDriver().findElements(By.cssSelector("#js-area-list input[type='checkbox']"));
		for (int i = 0; i < checkboxs.size(); i++) {
			if (checkboxs.get(i).isSelected()) {
				return true;
			}
		}
		return false;
	}

	
	public boolean isSelectedPlace() throws InterruptedException
	{
		
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector("#js-area-list dt")); // number row = 9
		
		boolean isShow = false;
		for (int i = 1; i <= allOptions.size(); i++) {
			List<String> foo = new ArrayList<String>();
			if(i>1)
			{
				openPopupPlace();
			}

			allChkPlaceOFF.click();
			WebElement itemMain = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"js-area-list\"]/dl["+i+"]/dt/label/span")); // item main
			itemMain.click();
			List<WebElement> numSelected = DriverUtils.getDriver().findElements(By.xpath("//*[@id=\"js-area-list\"]/dl["+i+"]/dd/ul//span")); //list selected
			for(int j = 1; j<= numSelected.size(); j++ ) {
				WebElement item = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"js-area-list\"]/dl["+i+"]/dd/ul/li["+j+"]/label/span"));
				foo.add(item.getText());
				
			}
			String expectText2 = String.join(",", foo);
			btnChoosePlace.click();
			String currenttext = txtPlace.getAttribute("value");
			if(currenttext.equals(expectText2))
			{
				isShow = true;
			}
			else
			{
				isShow = false;
			}
		}
		return isShow;
	}
	

}