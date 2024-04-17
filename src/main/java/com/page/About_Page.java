package com.page;

import org.openqa.selenium.By;

import com.common.Button;
import com.common.Constant;
import com.common.Image;
import com.common.Label;

public class About_Page extends Common_Page {
	Button abstruct = new Button(By.xpath("//div[@class='submenu']/a[@href='#abstruct']"));
	String abstruct1 = "//div[@class='submenu']/a[@href='#abstruct']";
	Button subsidy = new Button(By.xpath("//div[@class='submenu']/a[@href='##subsidy']"));
	Button land = new Button(By.xpath("//div[@class='submenu']/a[@href='#land']"));
	Image view_Abstruct = new Image(By.xpath("//img[@alt='REASON1']"));
	Label view_Subsidy = new Label(By.xpath("//p[@class='lead']//preceding-sibling::h3[@class='ttl-type_002 sub']"));
	Label view_Land = new Label(By.xpath("//dl[@class='lead-type_001']//following::h3"));

	public boolean isViewPortAbstruct() throws InterruptedException
	{
		boolean isView = false;
		abstruct.click();
		Thread.sleep(Constant.MIN_TIME);
		if(isVisibleInViewport(view_Abstruct.getRuntimeElement()))
			isView =  true;
		else
			isView = false;
		return isView;
	}
	
	public boolean isViewPortAbstruct1(String text) throws InterruptedException
	{
		boolean isView = false;
		if(text.equals("abstruct"))
		{
			abstruct.click();
			Thread.sleep(Constant.MIN_TIME);
			if(isVisibleInViewport(view_Abstruct.getRuntimeElement()))
				isView =  true;
		}
		else if(text.equals("subsidy"))
		{
			subsidy.click();
			Thread.sleep(Constant.MIN_TIME);
			if(isVisibleInViewport(view_Subsidy.getRuntimeElement()))
				isView =  true;
		}
		else if(text.equals("land"))
		{
			land.click();
			Thread.sleep(Constant.MIN_TIME);
			if(isVisibleInViewport(view_Land.getRuntimeElement()))
				isView =  true;
		}
		else
			isView = false;
		return isView;
	}
}