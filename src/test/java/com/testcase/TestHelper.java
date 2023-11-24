package com.testcase;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.common.Constant;
import com.common.DriverUtils;

public class TestHelper {

	@BeforeClass
	public void BeforeClass(){
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.URLHOME);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void afterClass() {
		DriverUtils.getDriver().quit();
	}
	
//	public int randomNum(){
//		Random r = new Random();
//		return r.nextInt(100000) + 1;
//	}
//	
//	public void scrollPage() {
//		JavascriptExecutor js = (JavascriptExecutor) DriverUtils.getDriver();
//		js.executeScript("window.scrollBy(0,1000)");
//	}

}
