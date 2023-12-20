package com.common;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.util.HashMap;
import com.common.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtils {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		Constant.folderName = System.getProperty("user.dir") + File.separator + "Downloads"; // save in project đang run với folder Dơnloads
		chromePrefs.put("download.default_directory", Constant.folderName);
		option.setExperimentalOption("prefs", chromePrefs);

		driver = new ChromeDriver(option);
		driver.navigate().refresh();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

}
