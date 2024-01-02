package com.page;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.Listbox;
import com.common.Message;
import com.common.Textbox;

public class Common_Page {
	Textbox txtOR = new Textbox(By.cssSelector("#subjectORTable input.subjectOR:nth-child(1)"));
	Button search = new Button(By.cssSelector("a#btn_form_submit>span.nk-btn-inner"));
	Button downloadCSV = new Button(By.id("export_csv"));
	Message msPopupError = new Message(By.cssSelector(".condition__text-result.flex-warn span"));
	Button closePopupError = new Button(By.xpath("//p[@class=\"condition__text-result flex-warn\"]/preceding::label[@for=\"js-message\"]"));
	Listbox numPage = new Listbox(By.cssSelector("#frmPagesize"));
	Label listResult = new Label(By.xpath("//*[@id=\"searchResult\"]"));



	// Variable public
	String defaultWindow = "";

	
	//I. FUNCTION DEFINE
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
	
	public void delete_File()
	{
		File[] listOfFiles =  new File(Constant.folderName).listFiles();
		if(listOfFiles.length > 0)
		{
			for(int  i = 0; i< listOfFiles.length; i++)
			{
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
	
	public boolean is_Visible_IMG( WebElement img) {
		boolean foo = false;
		Boolean is_visibleIMG = (Boolean) ((JavascriptExecutor)DriverUtils.getDriver()) .executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", img);
		if (is_visibleIMG){
			foo = true;
		} else {
			foo = false;
		}
		return foo;			
	}


	public static Boolean isVisibleInViewport(WebElement element) {

		  return (Boolean)((JavascriptExecutor)DriverUtils.getDriver()).executeScript(
		      "var elem = arguments[0],                 " +
		      "  box = elem.getBoundingClientRect(),    " +
		      "  cx = box.left + box.width / 2,         " +
		      "  cy = box.top + box.height / 2,         " +
		      "  e = document.elementFromPoint(cx, cy); " +
		      "for (; e; e = e.parentElement) {         " +
		      "  if (e === elem)                        " +
		      "    return true;                         " +
		      "}                                        " +
		      "return false;                            "
		      , element);
		}
	
    public void openDialog(WebElement element) {
    	element.click();
        defaultWindow = DriverUtils.getDriver().getWindowHandle();
        ArrayList<String> tabs = new ArrayList<String> (DriverUtils.getDriver().getWindowHandles());
        tabs.remove(defaultWindow);
        DriverUtils.getDriver().switchTo().window( tabs.get(0));

    }
    
    
    
  //II. UI DEFINE
    
//    public void getColorText(WebElement element)
//    {
//    	Actions actions = new Actions(driver);
//    	String text_color = element.getCssValue("color");
//    	
//    }
}