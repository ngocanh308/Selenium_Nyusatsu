package com.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.Label;
import com.common.LinkText;
import com.common.Listbox;
import com.common.Textbox;
import com.common.ultilities.Log;

public class Contact_Page extends Common_Page {
	public Label lblError = new Label(By.id("showError")); // Get error
	
	String typeAccount = ".list-block li:nth-child(%s) span"; // page Input contact
	String paidAccount = ".membership.paid-membership option";
	private final String lblTitleField = "//*[@id='frmContact']/dl[%s]/dt";
	Label lblChooseOne = new Label(By.cssSelector("div.txt.membership-caption"));
	Listbox lstChild = new Listbox(By.cssSelector("label.select-parts select.active"));
	public Textbox txtName = new Textbox(By.id("frmName"));
	public Textbox txtCompanyName = new Textbox(By.id("frmName2"));
	public Textbox txtPhone = new Textbox(By.id("frmTel"));
	public Textbox txtMail = new Textbox(By.id("frmEmail"));
	public Textbox txtNote = new Textbox(By.id("frmDetail"));
	public Button btnSubmit = new Button(By.xpath("//*[@id='btn-confirm']"));

	public Label lblHeaderConfirm = new Label(By.cssSelector("#contact_step2  h1.ttl-type_003")); // page confirm contact
	public Label lblChildHeaderConfirm = new Label(By.cssSelector("#contact_step2  p.lead"));
	Label lblTypeAccount = new Label(By.id("frmType_step2"));
	Label lblName = new Label(By.id("frmName_step2"));
	Label lblCompany = new Label(By.id("frmName2_step2"));
	Label lblPhone = new Label(By.id("frmTel_step2"));
	Label lblmail = new Label(By.id("frmEmail_step2"));
	Label lblDetail = new Label(By.id("frmDetail_step2"));
    Button btnConfirm = new Button(By.id("btn-regist"));
	Button btnBackConfirm= new Button(By.cssSelector(".btn-back"));
	
	public Label lblChildHeaderFinish = new Label(By.cssSelector("#contact_step3  h1.ttl-type_003"));// page finished
	public Label lblFinish1 = new Label(By.cssSelector("p.txt")); 
	Label lblFinish2 = new Label(By.xpath("//*[@id='complete']/div/p[1]/text()[2]")); 
	Label lblFinish3 = new Label(By.xpath("//*[@id='complete']/div/p[1]/text()[3]")); 
	public LinkText LikTopPage = new LinkText(By.cssSelector("p.link-type_001 a")); 

	// Common page contact
	public List<String> getTitleFieldContact() {
		List<String> lstTitle = new ArrayList<String>();
		List<WebElement> totalField = DriverUtils.getDriver().findElements(By.xpath("//*[@id='frmContact']/dl"));
		for (int i = 1; i <= totalField.size(); i++) {
			lstTitle.add(DriverUtils.getDriver().findElement(By.xpath("//*[@id='frmContact']/dl[" + i + "]/dt")).getText());
		}

		return lstTitle;
	}

	
	public List<String> getTitleFieldConfirmContact() {
		List<String> lstTitle = new ArrayList<String>();
		List<WebElement> totalField = DriverUtils.getDriver().findElements(By.xpath("//*[@class='form-block']/dl"));
		for (int i = 1; i <= totalField.size(); i++) {
			lstTitle.add(DriverUtils.getDriver().findElement(By.xpath("//*[@class='form-block']/dl[" + i + "]/dt")).getText());
		}

		return lstTitle;
	}
	public String getTextLabel(Label item) {
		return item.getTextLabel();
	}
	
	public String getTextLabelFinish(Label item) {
		return item.getTextLabel().replace("\n", "").replace("\r", "") ;
	}
	
	public List<String> getErrorContact(boolean isEmpty) throws InterruptedException
	{
		List<String> actualText = new ArrayList<String>();
		if(isEmpty)
		{
			scrollToElementBottom(btnSubmit.getRuntimeElement());
			Thread.sleep(Constant.SORT_TIME);
			btnSubmit.click();
		}
		List<WebElement> lstText = DriverUtils.getDriver().findElements(By.cssSelector("#showError span"));
		int j = 1;
		for(int i=1; i<= lstText.size(); i++)
		{
			j = (i*2) -1;;
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("#showError span:nth-child("+j+")"));
			actualText.add(item.getText().trim());
		}
		return actualText;
	}


	// 1. List type account 現在のご利用状況
	public boolean validateValuePaidAccount(String name, String[] expectList) {
		WebElement dropdown = DriverUtils.getDriver().findElement(By.xpath(String.format(paidAccount, name)));
		Select sel = new Select(dropdown);
		List<WebElement> option = sel.getOptions();
		for (int i = 0; i < option.size(); i++) {
			if (option.get(i).getText().equals(expectList[i])) {
				return true;
			}
		}
		return false;
	}

	public List<String> getTextListAccount() {
		List<String> text = new ArrayList<String>();
		List<WebElement> lstText = DriverUtils.getDriver().findElements(By.cssSelector(".list-block li span"));
		for (WebElement element : lstText) {
			text.add(element.getText());
		}
		return text;

	}

	public boolean isUncheckAllTypeAccount() {
		boolean isCheck = true;
		List<WebElement> lstOption = DriverUtils.getDriver().findElements(By.cssSelector(".list-block li"));
		for (int i = 0; i < lstOption.size(); i++) {
			if (lstOption.get(i).isSelected()) {
				isCheck = false;
			}
		}
		return isCheck;
	}

	public boolean isSelectedTypeAccount() throws InterruptedException {
		boolean isSelected = true;
		List<WebElement> lstOption = DriverUtils.getDriver().findElements(By.cssSelector(".list-block li"));
		for (int i = 1; i <= lstOption.size(); i++) {
			WebElement span = DriverUtils.getDriver().findElement(By.cssSelector(".list-block li:nth-child(" + i + ") span"));
			scrollToElementBottom(span);
			Thread.sleep(Constant.LIT_TIME);
			span.click();
			WebElement input = DriverUtils.getDriver().findElement(By.cssSelector(".list-block li:nth-child(" + i + ") input"));
			if (!input.isSelected()) {
				isSelected = false;
			}

		}
		return isSelected;
	}

	// 2. List child account お問い合わせ種別
	public boolean isHideTextChild() throws InterruptedException {
		List<WebElement> lstOption = DriverUtils.getDriver().findElements(By.cssSelector(".list-block li"));
		boolean result = true;
		for (int i = 1; i <= lstOption.size(); i++) {
			DriverUtils.getDriver().navigate().refresh();
			WebElement span = DriverUtils.getDriver().findElement(By.cssSelector(".list-block li:nth-child(" + i + ") span"));
			scrollToElementBottom(span);
			Thread.sleep(Constant.LIT_TIME);
			span.click();
			String text = "";
			WebElement lblChoose = DriverUtils.getDriver().findElement(By.cssSelector("div.txt.membership-caption"));
			visibleElementHidden(lblChoose);
			text = lblChoose.getAttribute("style");
			if (!text.equals("display: none;")) {
				result = false;
			}
		}
		return result;
	}

	public List<String> listChildType(Integer num) throws InterruptedException // num = 2(regular),3(trial),4(Other)
	{
		List<String> actual = new ArrayList<String>();
		WebElement span = DriverUtils.getDriver().findElement(By.cssSelector(".list-block li:nth-child(" + (num - 1) + ") span"));
		scrollToElementBottom(span);
		Thread.sleep(Constant.LIT_TIME);
		span.click();
		List<WebElement> lstChild = DriverUtils.getDriver().findElements(By.cssSelector("label.select-parts select:nth-child(" + num + ") option"));
		for (int i = 1; i <= lstChild.size(); i++) {
			WebElement item = DriverUtils.getDriver().findElement(By.cssSelector("label.select-parts select:nth-child(" + num + ") option:nth-child(" + i + ")"));
			actual.add(item.getText().trim());
		}
		return actual;
	}

	// 3. Send infor contact save into list info to verify
	public List<String> inputContact(Integer type, int childType, String name, String company, String phone, String mail, String note) throws InterruptedException {
		List<String> infor = new ArrayList<String>();
		WebElement chooseType = DriverUtils.getDriver().findElement(By.cssSelector(String.format(typeAccount, type)));
		scrollToElementBottom(chooseType);
		Thread.sleep(Constant.LIT_TIME);
		chooseType.click();
		infor.add(chooseType.getText());
		selectChildType(childType);
		infor.add(lstChild.getTextDisplay());
		txtName.type(name);
		infor.add(txtName.getTextValueNotTrim("value"));
		txtCompanyName.type(company);
		infor.add(txtCompanyName.getTextValueNotTrim("value"));
		txtPhone.type(phone);
		infor.add(txtPhone.getTextValueNotTrim("value"));
		txtMail.type(mail);
		infor.add(txtMail.getTextValueNotTrim("value"));
		txtNote.type(note);
		infor.add(txtNote.getTextValueNotTrim("value"));

		scrollToElementBottom(btnSubmit.getRuntimeElement());
		Thread.sleep(Constant.MIN_TIME);
		btnSubmit.click();
		Constant.LIST_CONTACT_INPUT = convertListType(infor);
		return Constant.LIST_CONTACT_INPUT;
	}
	


	public List<String> getInforContact() {
		List<String> getInfor = new ArrayList<String>();
		getInfor.add(lblTypeAccount.getTextLabel());
		getInfor.add(lblName.getTextLabel());
		getInfor.add(lblCompany.getTextLabel());
		getInfor.add(lblPhone.getTextLabel());
		getInfor.add(lblmail.getTextLabel());
		getInfor.add(lblDetail.getTextLabel());
		Constant.LIST_CONTACT_DISPLAY =  getInfor;
		return Constant.LIST_CONTACT_DISPLAY;

	}

	public void selectChildType(int index) {
		lstChild.selectIndex(index);
	}

	public boolean isInputContactSuccess() {
		boolean result = true;
		if (!lblHeaderConfirm.isDisplay()) {
			result = false;
		}
		return result;
	}

	public List<String> convertListType(List<String> actualList) {  // convert from [item1,item2, AutoName]  to [【item1】item2, AutoName]
		String tmp = "";
		tmp = "【" + actualList.get(0) + "】";
		actualList.set(1, tmp + actualList.get(1));
		actualList.remove(0);
		return actualList;

	}
	// Finish	
	public void clickFinish() throws InterruptedException
	{
		getInforContact();
		scrollToElementBottom(btnConfirm.getRuntimeElement());
		Thread.sleep(Constant.SORT_TIME);
		btnConfirm.click();
	}
	

}