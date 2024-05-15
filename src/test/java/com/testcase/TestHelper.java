package com.testcase;

import java.io.File;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.common.Constant;
import com.common.DriverUtils;

public class TestHelper {

	@BeforeClass
	public void BeforeClass() {
		DriverUtils.setUpDriver();
		DriverUtils.getDriver().get(Constant.URL_HOME_AUTHEN);
		DriverUtils.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		DriverUtils.getDriver().quit();
	}

	public void captureScreenShot(String methodname) throws IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy/MM/dd_HH:mm:ss");
		ZonedDateTime now = ZonedDateTime.now();
		ZonedDateTime japanDateTime = now.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));
		String time = dtf.format(japanDateTime).replaceAll("/| |:|\\.", "");
		TakesScreenshot scrShot = ((TakesScreenshot) DriverUtils.getDriver());
		File file = scrShot.getScreenshotAs(OutputType.FILE);
		Constant.folderImage = System.getProperty("user.dir") +  "/Image" + File.separator;
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/Image" + File.separator + "EVIDENCE_" + methodname + time + ".jpg"));
	}

}
