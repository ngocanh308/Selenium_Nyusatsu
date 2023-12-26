package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.common.Button;
import com.common.Constant;
import com.common.DriverUtils;
import com.common.LinkText;
import com.common.Message;
import com.common.Textbox;


public class URLLink_AllPage extends Common_Page {
	public boolean is_Visible_URL( String expect_URL) throws InterruptedException {
		boolean is_visible = false;
		String actual_URL = DriverUtils.getDriver().getCurrentUrl();
		if (actual_URL.equals(expect_URL)) {
			is_visible = true;
		} else {
			is_visible = false;
		}
		return is_visible;
	}
	
	public boolean is_Visible_Text(WebElement element, String expect_Text) {
		boolean visible_text = false;
		String actual_Text = element.getText();
		if (actual_Text.equals(expect_Text)){
			visible_text = true;
		} else {
			visible_text = false;
		}
		return visible_text;			
	}
	
	public boolean is_Visible_Text_BR(WebElement element, String expect_Text) {
		boolean visible_text = false;
		String actual_Text = element.getText().replace("\n","");
		if (actual_Text.equals(expect_Text)){
			visible_text = true;
		} else {
			visible_text = false;
		}
		return visible_text;			
	}

}