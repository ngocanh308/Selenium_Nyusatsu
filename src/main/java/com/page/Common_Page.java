package com.page;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.Checkbox;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.common.Listbox;
import com.common.Message;
import com.common.Textbox;

public class Common_Page {
	Textbox txtOR = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(1)"));
	Textbox txtORList = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(%s)"));
	Textbox txtAND = new Textbox(By.cssSelector("#workKindANDTable input.workKindAND:nth-child(1)"));
	Button closeWarning = new Button(By.cssSelector("#message_modal > div > div > label"));
	Button addAND = new Button(By.id("subjectANDInput"));
	Button btnSearch = new Button(By.cssSelector("a#btn_form_submit>span.nk-btn-inner"));
	Button downloadCSV = new Button(By.id("export_csv"));
	Message msPopupError = new Message(By.cssSelector(".condition__text-result.flex-warn span"));
	Button closePopupError = new Button(By.xpath("//p[@class=\"condition__text-result flex-warn\"]/preceding::label[@for=\"js-message\"]"));
	Listbox numPage = new Listbox(By.cssSelector("#frmPagesize"));
	Label listResult = new Label(By.xpath("//*[@id=\"searchResult\"]"));

	private final String btnClosePopup = "label.nk-modal__close.js-modal-close[for='%s']";// Common close popup

	Button allCheckboxsOFF = new Button(By.id("js-block-off"));// Popup Area
	Button allCheckboxsON = new Button(By.id("js-block-on"));
	Button checkUncheckArea = new Button(By.id("js-check-all-s-block"));
	Button btnOpenArea = new Button(By.id("block_open_button"));
	Button btnCloseArea = new Button(By.xpath("//*[@id=\"default_block\"]//label[@for='js-block']"));
	Button btnSearchArea = new Button(By.id("js-block-btn"));
	Textbox txtArea = new Textbox(By.cssSelector("#frmS_BLOCK_NAME"));

	// #js-area-list input[type='checkbox']
	Button allChkPlaceOFF = new Button(By.id("js-area-off"));
	Button allChkPlaceON = new Button(By.id("js-area-on"));

	Button btnOpenPopupPlaceYotei = new Button(By.cssSelector(".nk-btn.yotei-search__btn--area .nk-btn-inner")); // popup place 発注地域
	Button btnClosePopupPlaceYotei = new Button(By.cssSelector("label.nk-modal__close.js-modal-close[for='js-area']"));
	String btnOpenPopupPlaceBoth = "//label[@data-mode='%s']";
	Button btnOpenPopupPlaceRaku = new Button(By.xpath("//label[@data-mode=\"rakusatsu\"]"));
	Checkbox ckbItemmainArea = new Checkbox(By.xpath("//*[@id=\"js-area-list\"]/dl[3]/dt/label/span"));
	Textbox txtPlaceYotei = new Textbox(By.id("frmAREA_NAME"));
	Textbox txtPlaceNyu = new Textbox(By.id("nyusatsuFrmAREA_NAME"));
	Textbox txtPlaceRaku = new Textbox(By.id("rakusatsuFrmAREA_NAME"));
	Button btnChoosePlace = new Button(By.cssSelector(".regist-input__pref-info .nk-btn-inner"));

	private final String listCkbTypeBid = "div.%s";

	Button btnOpenBookmark = new Button(By.cssSelector(".nk-btn.js-saved-open")); // bookmark popup
//	Button btnRedDeleteBookmarkItem = new Button(By.xpath("//span[text()=\"削除\"][@class=\"condition__form-btn-update js-condition-delete-submit\"]"));
	Button btnRedDeleteBookmarkItem = new Button(By.cssSelector(".condition__form-btn-update.js-condition-delete-submit"));
	Button btnGrayDeleteBookmarkItem = new Button(By.cssSelector("li.saved-item:nth-child(2) a.saved-item-delete"));
	Button btnCloseDeleteBookmark = new Button(By.xpath("//*[@id=\"dataSearch\"]//label[@for='js-condition-delete-result']"));
	Label lblNameBookmark = new Label(By.cssSelector("li.saved-item:nth-child(2) span.saved-item-name"));
	Button btnOpenItemBookmark = new Button(By.cssSelector("#list_search_notice > ul > li:nth-child(2) > a.saved-item-call"));
	Label lblNameBookmarkTop = new Label(By.cssSelector("div.ttl-cnt--label"));
//	Label lblNameBookmarkTop = new Label(By.cssSelector("#list_search_notice li:nth-child(2) > span.saved-item-name"));
	String leftArea = "#js-block__large-list > ul > li:nth-child(3) > a";
	Button btnClosePopupBookmark = new Button(By.cssSelector("#callSearchCondition label.nk-modal__close"));
	Textbox txtNameBookmark = new Textbox(By.id("inputSerchNoticeName"));
	Button btnYesAddBookmark = new Button(By.cssSelector("div.condition__form-btn-wrap span.condition__form-btn-add.js-condition-add-submit"));
	Button btnClosePopupConfirm = new Button(By.xpath("//*[@id=\"dataSearch\"]//label[@for=\"js-condition-add-result\"]"));

	Checkbox ckbStopMail = new Checkbox(By.xpath("//input[@id='search_flg']//following-sibling::span[@class='check-parts']"));

	// Variable public
	String defaultWindow = "";

	// I. FUNCTION DEFINE
	public void inputOR(String inputText) throws InterruptedException {
		txtOR.type(inputText);
		btnSearch.click();
	}

	public void downloadCSV(String inputText) throws InterruptedException {
		txtOR.type(inputText);
		btnSearch.click();
		Thread.sleep(Constant.SORT_TIME);
		downloadCSV.click();
		Thread.sleep(Constant.SORT_TIME);
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

	public void closePopupFaild() {
		closePopupError.click();

	}

	public void closePopup(String jsType) { // popup area = js-block, popup place = js-area, popup type = js-category, popup
											// kw suggest = js-kw, require select 1 checkbox = js-message
		String forText = "";
		if (jsType.equals("Area")) {
			forText = "js-block";
		} else if (jsType.equals("Place")) {
			forText = "js-area";
		} else if (jsType.equals("Type")) {
			forText = "js-category";
		} else if (jsType.equals("KWSuggest")) {
			forText = "js-kw";
		} else if (jsType.equals("Choose")) {
			forText = "js-message";
		} else if (jsType.equals("Mail")) {
			forText = "js-stop-search-notice";
		}

		WebElement item = DriverUtils.getDriver().findElement(By.cssSelector(String.format(btnClosePopup, forText)));
		item.click();

	}

	public boolean isDisplayResult() throws InterruptedException {
		Thread.sleep(Constant.MIN_TIME);
		WebElement result = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"searchResult\"]"));
		if (StringUtils.isNoneBlank(result.getText())) {
			return true;
		}
		return false;
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

	// 2.Checkbox 入札種別 , checkbox 資格ランク
	public String getTextListCheckboxTypeBid(String page) {
		String forText = "";
		if (page.equals("Both_Type")) {
			forText = "both-item-search__bid";
		}
		if (page.equals("Yotei_Type")) {
			forText = "yotei-search__bid";
		}
		if (page.equals("Both_Rank")) {
			forText = "both-item-search__rank";
		}
		if (page.equals("Both_Search_In")) {
			forText = "both-item-search__kw-type";
		}
		WebElement listChk = DriverUtils.getDriver().findElement(By.cssSelector(String.format(listCkbTypeBid, forText)));
		String listText = listChk.getText().replace("\n", "").replace(" ", "");
		return listText;
	}

	public boolean ischeckUncheckListCheckbox(String page) {
		boolean ischeck = false;
		String forText = "";
		if (page.equals("Both_Type")) {
			forText = "both-item-search__bid";
		} else if (page.equals("Yotei_Type")) {
			forText = "yotei-search__bid";
		} else if (page.equals("Both_Rank")) {
			forText = "both-item-search__rank";
		}
		String list = "//div[@class='%s']//input";
		List<WebElement> listChk = DriverUtils.getDriver().findElements(By.xpath(String.format(list, forText)));
		for (int i = 1; i <= listChk.size(); i++) {
			String chks = "//div[@class='%s']/label[" + i + "]//span";
			WebElement chkSpan = DriverUtils.getDriver().findElement(By.xpath(String.format(chks, forText)));
			String chki = "//div[@class='%s']/label[" + i + "]//input";
			WebElement chkInput = DriverUtils.getDriver().findElement(By.xpath(String.format(chki, forText)));
			chkSpan.click();
			if (!chkInput.isSelected()) {
				ischeck = true;
			} else {
				ischeck = false;
			}
			chkSpan.click();
			if (chkInput.isSelected()) {
				ischeck = true;
			} else {
				ischeck = false;
			}
		}
		return ischeck;
	} // END 2.Checkbox 入札種別 , checkbox 資格ランク

	// 3. Mail
	public boolean showPopupSendMail() throws InterruptedException {

		boolean result = false;
		ckbStopMail.click();
		if (!DriverUtils.getDriver().findElements(By.xpath("//div[@id='stopSearchNotice']//div[@class='form-type-full ']")).isEmpty()) {
			result = true;
		} else {
			result = false;
		}
		return result;

	}

	// 4. Select correct listbox common
	public boolean selectValueListbox(Listbox list, String[] expectText) {
		boolean result = true;
		List<String> actualText = new ArrayList<String>();

		for (int i = 1; i < list.size(); i++) {
			list.selectIndex(i);
			actualText.add(list.getTextDisplay());
			if (!actualText.get(i - 1).equals(expectText[i - 1])) {
				result = false;
			}

		}

		return result;
	}

	public String getValueListYear(Listbox list1, Listbox list2, Listbox list3, String join) {
		List<String> text = new ArrayList<String>();
		text.add(list1.getTextDisplay());
		text.add(list2.getTextDisplay());
		text.add(list3.getTextDisplay());
		for (int i = 0; i < text.size(); i++) {
			if (text.get(i).length() == 1) {
				text.set(i, "0" + text.get(i));
			}
		}
		String actualText = String.join(join, text);
		return actualText;
	}

	// Open detail item ( Yotei, Nyusatsu, Rakusatsu )
	public boolean isOpenDetailItem(String page, LinkText SubjectSearch, LinkText IDSearch, LinkText SubjectDetail, Label IDDetail) throws InterruptedException {
		boolean isResult = true;
		List<String> expectItem = new ArrayList<String>();
		List<String> actualItem = new ArrayList<String>();
		btnSearch.click();
		Thread.sleep(Constant.SORT_TIME);
		expectItem.add(SubjectSearch.getTextLink());
		expectItem.add(IDSearch.getTextLink());
		SubjectSearch.clickLinkText();

		String winHandleBefore = DriverUtils.getDriver().getWindowHandle(); // save current windown
		for (String winHandle : DriverUtils.getDriver().getWindowHandles()) { // switch new windown
			DriverUtils.getDriver().switchTo().window(winHandle);
		}
		// Perform the actions on new window
		actualItem.add(SubjectDetail.getTextLink());

		// Make hidden element visible and then get value

		if (page.equals("Yotei")) {
			JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
			WebElement element = DriverUtils.getDriver().findElement(By.cssSelector("#yotei-detail input.anken_id"));
			js.executeScript("arguments[0].setAttribute('type', '')", element);
			actualItem.add(IDDetail.getAttribute("value"));
		} else {
			actualItem.add(IDDetail.getTextLabel().trim());
		}
		for (int i = 0; i < expectItem.size(); i++) {
			if (!expectItem.get(i).equals(actualItem.get(i))) {
				isResult = false;
			}
		}
		DriverUtils.getDriver().close();

		// Switch back to original browser (first window)
		DriverUtils.getDriver().switchTo().window(winHandleBefore);
		return isResult;

	}


	// II . FUNCTION

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

		return (Boolean) ((JavascriptExecutor) DriverUtils.getDriver())
				.executeScript("var elem = arguments[0],                 " + "  box = elem.getBoundingClientRect(),    " + "  cx = box.left + box.width / 2,         " + "  cy = box.top + box.height / 2,         " + "  e = document.elementFromPoint(cx, cy); " + "for (; e; e = e.parentElement) {         " + "  if (e === elem)                        " + "    return true;                         " + "}                                        " + "return false;                            ", element);
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
	// 1. Common Alert
	public boolean isAlertPresent() {
		try {
			DriverUtils.getDriver().switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		}
	}

	// 2. Common Placehoder element
	public String getPlaceHolder(Textbox element) {
		String text = element.getAttribute("placeholder");
		return text;
	}

	// 3. TEXTBOX check input max number textboxs define
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
			if (mail == true) {
				uuid = uuid.substring(0, Math.min(uuid.length(), maxlenghText)) + "@zuno.vc";
			} else {
				uuid = uuid.substring(0, Math.min(uuid.length(), maxlenghText));
			}

			text_input.add(uuid);
			if (popup == true && i == 2) {
				textbox.click();
				Thread.sleep(Constant.MIN_TIME);
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

	// 4. Check max lenght 1 textbox

	public boolean maxLenghtTextbox(Textbox txt, String inputLength, String max) {
		boolean result = true;
		txt.type(inputLength);
		String text = txt.getAttribute("value");
		if (!text.equals(max))
			result = false;
		return result;
	}

	// 5. POPUP AREA 発注機関選択
	public void openPopupArea() {
		btnOpenArea.click();
	}

	public boolean isHighlightWhenClickLeftItem(Button popup, String leftItem, String textColor, String backgroundColor) throws InterruptedException {
		popup.click();
		Thread.sleep(Constant.SORT_TIME);
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
	} // END 5. POPUP AREA 発注機関選択

	// 6. Check_Uncheck right item when select 1 left item in popup Area (ONLY EXIST
	// // AREA POPUP)
	public boolean isCheckUncheckListItemPopupArea(String listLeft, String itemLeft, String itemRight) throws InterruptedException {
		allCheckboxsOFF.click();
		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector(String.format(listLeft)));
		List<String> foo = new ArrayList<String>();
		boolean ischeck = false;
		for (int i = 2; i <= allOptions.size(); i++) {
			WebElement leftItem = DriverUtils.getDriver().findElement(By.cssSelector(itemLeft + i + ")"));
			foo.add(leftItem.getText());
			String textItem = leftItem.getText() + "全てを選択";
			leftItem.click();
			String index = leftItem.getAttribute("data-index");
			Thread.sleep(300);
			if (i > 2 && i != 19) {
				String textButton = checkUncheckArea.getTextButton();
				if (textItem.equals(textButton)) {
					checkUncheckArea.click();
					List<WebElement> rightCheckbox = DriverUtils.getDriver().findElements(By.xpath(itemRight + index + "']//input[@class='js-block-m-check']"));
					for (int j = 0; j < rightCheckbox.size(); j++) {
						if (rightCheckbox.get(j).isSelected()) {
							ischeck = true;
						} else {
							ischeck = false;
						}
					}
				}
			} else {
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

	// 7. Header page
	public boolean clickHeaderMenu(int numItem, String expectURLNavigate) {
		boolean correctURL = false;
		WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("#global > ul > li:nth-child(" + numItem + ") > a"));
		item.click();
		String currentURL = DriverUtils.getDriver().getCurrentUrl();
		if (currentURL.equals(expectURLNavigate)) {
			correctURL = true;
			DriverUtils.getDriver().navigate().back();

		} else {
			correctURL = false;
		}
		return correctURL;

	}

	// 8. POPUP PLACE 発注地域
	public void openPopupPlaceYotei() {
		btnOpenPopupPlaceYotei.click();
	}

	public void closePopupPlaceTmp() {
		btnClosePopupPlaceYotei.click();
	}

	public void openPopupPlaceBoth(String add) {
		WebElement item = DriverUtils.getDriver().findElement(By.xpath(String.format(btnOpenPopupPlaceBoth, add)));
		item.click();
	}

	public void openPopupPlaceRaku() {
		btnOpenPopupPlaceRaku.click();
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

	public boolean isSelectedPlace(String name) throws InterruptedException {

		List<WebElement> allOptions = DriverUtils.getDriver().findElements(By.cssSelector("#js-area-list dt")); // number row = 9

		boolean isShow = false;
		for (int i = 1; i <= allOptions.size(); i++) {
			List<String> foo = new ArrayList<String>();
			if ((i > 1)) {
				if (name.equals("Yotei")) {
					openPopupPlaceYotei();
				} else if (name.equals("Nyusatsu")) {
					openPopupPlaceBoth("nyusatsu");
				} else if (name.equals("Rakusatsu")) {
					openPopupPlaceBoth("rakusatsu");
				} else {
					openPopupPlaceRaku();
				}
			}

			allChkPlaceOFF.click();
			WebElement itemMain = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"js-area-list\"]/dl[" + i + "]/dt/label/span")); // item main
			itemMain.click();
			List<WebElement> numSelected = DriverUtils.getDriver().findElements(By.xpath("//*[@id=\"js-area-list\"]/dl[" + i + "]/dd/ul//span")); // list selected
			for (int j = 1; j <= numSelected.size(); j++) {
				WebElement item = DriverUtils.getDriver().findElement(By.xpath("//*[@id=\"js-area-list\"]/dl[" + i + "]/dd/ul/li[" + j + "]/label/span"));
				foo.add(item.getText());

			}
			String expectText2 = String.join(",", foo);
			btnChoosePlace.click();
			String currenttext = new String();
			if (name.equals("Yotei")) {
				currenttext = txtPlaceYotei.getAttribute("value");
			} else if (name.equals("Nyusatsu")) {
				currenttext = txtPlaceNyu.getAttribute("value");
			} else {
				currenttext = txtPlaceRaku.getAttribute("value");
			}
			if (currenttext.equals(expectText2)) {
				isShow = true;
			} else {
				isShow = false;
			}
		}
		return isShow;
	}

	// Bookmark Yotei + Both
	public void openBookmark() {
		btnOpenBookmark.click();
	}

	public void closeBookmark() {
		btnClosePopupBookmark.click();
	}

	public void deleteAllBookmark() throws InterruptedException {
		openBookmark();
		List<WebElement> list = DriverUtils.getDriver().findElements(By.cssSelector(".saved-list.ui-sortable li"));
		while (list.size() > 1) {
			btnGrayDeleteBookmarkItem.click();
			btnRedDeleteBookmarkItem.click();
			btnCloseDeleteBookmark.click();
			List<WebElement> listBookmark = DriverUtils.getDriver().findElements(By.cssSelector(".saved-list.ui-sortable li"));
			if (listBookmark.size() == 1) {
				break;
			}

		}
	}

	public boolean isDeleteAllBookmark() {
		List<WebElement> currentlist = DriverUtils.getDriver().findElements(By.cssSelector(".saved-list.ui-sortable li"));
		if (currentlist.size() == 1)
			return true;
		return false;
	}

	public void addNewBookmarkCommon(String page) {
		List<String> temnpList = new ArrayList<String>();
		txtOR.type(Constant.TEXT_BOOKMARK_YOTEI[0]);
		if (page.equals("Yotei")) {
			txtAND.type(Constant.TEXT_BOOKMARK_YOTEI[1]);
		}
		openPopupArea();
		allCheckboxsOFF.click();
		WebElement leftItem = DriverUtils.getDriver().findElement(By.cssSelector(leftArea));
		leftItem.click();
		checkUncheckArea.click();
		btnSearchArea.click();
		if (page.equals("Yotei")) {
			openPopupPlaceYotei();
		} else {
			openPopupPlaceBoth("nyusatsu");
		}
		allChkPlaceOFF.click();
		ckbItemmainArea.click();
		btnChoosePlace.click();
		temnpList.add(txtOR.getTextValue("value"));
		if (page.equals("Yotei")) {
			temnpList.add(txtAND.getTextValue("value"));
		}
		temnpList.add(txtArea.getTextValue("value"));
		if (page.equals("Yotei")) {
			temnpList.add(txtPlaceYotei.getTextValue("value"));
		} else {
			temnpList.add(txtPlaceNyu.getTextValue("value"));
		}
		if (page.equals("Yotei")) {
			Constant.LIST_TEXT_ADD_BOOKMARK_UI_YOTEI = temnpList;
		} else {
			Constant.LIST_TEXT_ADD_BOOKMARK_UI_BOTH = temnpList;
		}
	}

	public void inputNameBookmark() {
		txtNameBookmark.type(Constant.NAME_BOOKMARK);
		btnYesAddBookmark.click();
		btnClosePopupConfirm.click();
	}

	public boolean isAddNewBookmark() throws InterruptedException {
		boolean isValid = false;
		openBookmark();
		String foo = new String();
		foo = lblNameBookmark.getTextLabel().trim();
		if (foo.equals(Constant.NAME_BOOKMARK)) {
			isValid = true;
		} else {
			isValid = false;
		}
		return isValid;
	}

	public boolean isShowCorrectBookmark(String page) {
		boolean result = true;
		btnOpenItemBookmark.click();
		if (lblNameBookmarkTop.getTextLabel().equals(Constant.NAME_BOOKMARK)) // check label on top page search display correct name bookmark slected
		{
			if (page.equals("Yotei")) {
				for (int i = 0; i < Constant.LIST_TEXT_ADD_BOOKMARK_UI_YOTEI.size(); i++) {
					if (!Constant.LIST_TEXT_ADD_BOOKMARK_UI_YOTEI.get(i).equals(Constant.LIST_TEXT_ADD_BOOKMARK_YOTEI.get(i)))
						result = false;
					break;
				}
			} else {
				for (int i = 0; i < Constant.LIST_TEXT_ADD_BOOKMARK_UI_BOTH.size(); i++) {
					if (!Constant.LIST_TEXT_ADD_BOOKMARK_UI_BOTH.get(i).equals(Constant.LIST_TEXT_ADD_BOOKMARK_BOTH.get(i)))
						result = false;
					break;
				}
			}
		}
		return result;
	}


	// Detail Anken

}