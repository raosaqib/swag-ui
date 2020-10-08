package com.globalkinetic.swaglabs.ui.logintest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globalkinetic.swaglabs.ui.browserconfig.config.ConfigReader;
import com.globalkinetic.swaglabs.ui.browserconfig.config.ObjectReader;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.homepage.HomePage;
import com.globalkinetic.swaglabs.ui.test.loginpage.LoginPage;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

/**
 * 
 * @author rao saqib
 *
 */

public class LoginTest extends TestBase {
	boolean status;
	String actualResult;
	LoginPage swagLoginPage;
	HomePage homePgeObj;

	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	
	@Test(description = "Validate user is navigated to corect application & validate title")
	public void getSwagAppTitle() throws Throwable {

		swagLoginPage = new LoginPage(driver);
		actualResult = swagLoginPage.getApplicationTitle();
		super.logExtentReport("Actual title of the application is " + actualResult);
		Assert.assertEquals(actualResult, ObjectReader.reader.getAppTitle(), "user is navigated to right application");

	}

	@Test(description = "Validate application logo is displaying propely")
	public void validateSwagAppLogo() throws Exception {

		actualResult = swagLoginPage.getApplicationLogo();
		super.logExtentReport("Actual logo of the application is " + actualResult);
		Assert.assertEquals(actualResult, "login_logo");

	}

	@Parameters({ "userName", "password", "homePageTextVal" })
	@Test(description = "Validate user is able to login successfully & navigated to home page")
	public void validateSwagAppValidLogin(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password, @Optional("Products") String homePageTextVal) throws Throwable {

		swagLoginPage = new LoginPage(driver);
		homePgeObj = swagLoginPage.validLogin(userName, password);
		actualResult = homePgeObj.getHomePageText();
		super.logExtentReport("user is able to login successfully:: " + status);

		Assert.assertEquals(actualResult, homePageTextVal, "user is able to login successfully");

	}

	@Parameters({ "invalidUserName", "wrongPassword" })
	@Test(description = "Validate user should remain on login page upon failure on login")
	public void ValidateSwagAppInvalidLogin(@Optional("problem_user") String invalidUserName,
			@Optional("wrongpassword") String wrongPassword) throws Throwable {

		swagLoginPage = new LoginPage(driver);
		swagLoginPage = swagLoginPage.inValidLogin(invalidUserName, wrongPassword);
		status = swagLoginPage.errorMessageButtonDisplayed();
		super.logExtentReport("Error message is displayed" + status);
		Assert.assertEquals(status, true);

	}
}
