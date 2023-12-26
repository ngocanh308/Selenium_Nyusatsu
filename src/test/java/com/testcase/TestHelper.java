package com.testcase;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.common.Constant;
import com.common.DriverUtils;

public class TestHelper {

	@BeforeClass
	public void BeforeClass() {
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.URL_HOME);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		DriverUtils.getDriver().quit();
	}

}
