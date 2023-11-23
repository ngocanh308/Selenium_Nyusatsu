package com.testcase;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.common.HomePage;
import com.common.LoginPage;

public class LoginTests extends BaseTests {

	@Test
	public void invalidCredentials() {

		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.login("Admin", "admin123$$");

		// Verify Error Message
		Assert.assertEquals("Invalid credentials", objLoginPage.getErrorMessage());

	}

	@Test
	public void gotoHomePage() {

		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.login("Admin", "admin123");

		HomePage objHomePage = new HomePage(driver);

		// Verify Home Page
		Assert.assertEquals("Employee Information", objHomePage.getHomePageText());

	}

	@Test
	public void missingUsername() {

		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.login("", "admin123");

		// Verify Error Message
		Assert.assertEquals("Invalid credentials", objLoginPage.getMissingUsernameText());

	}

	@Test
	@Ignore
	public void missingPassword() {

		LoginPage objLoginPage = new LoginPage(driver);
		objLoginPage.login("admin", "");

		// Verify Error Message
		Assert.assertEquals("Invalid credentials", objLoginPage.getMissingPasswordText());

	}

}