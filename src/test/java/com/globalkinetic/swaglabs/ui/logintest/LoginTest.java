package com.globalkinetic.swaglabs.ui.logintest;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.homepage.HomePage;
import com.globalkinetic.swaglabs.ui.test.loginpage.LoginPage;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

/**
 * 
 * @authorsaqib
 */
public class LoginTest extends TestBase {
	boolean status;
	String actualResult;
	LoginPage swagLoginPage;
	HomePage homePgeObj;

	private final Logger log = LoggerHelper.getLogger(LoginTest.class);

	@Parameters({ "title" })
	@Test(description = "Validate user is navigated to corect application & validate title")
	public void getSwagAppTitle(@Optional("Swag Labs") String appTitle) throws Throwable {
		try {
			swagLoginPage = new LoginPage(driver);
			actualResult = swagLoginPage.getApplicationTitle();
			super.logExtentReport("Actual title of the application is " + actualResult);
			Assert.assertEquals(actualResult, appTitle, "user is navigated to right application");

		} catch (Exception e) {
			Assert.fail("user not navigated to corect application");
			throw e;
		}
	}

	@Test(description = "Validate application logo is displaying propely")
	public void validateSwagAppLogo() throws Exception {
		try {
			actualResult = swagLoginPage.getApplicationLogo();
			super.logExtentReport("Actual logo of the application is " + actualResult);
			Assert.assertEquals(actualResult, "login_logo");

		} catch (Exception e) {
			Assert.fail("correct logo is not displaying");
			throw e;
		}
	}

	@Parameters({ "userName", "password", "homePageTextVal" })
	@Test(description = "Validate user is able to login successfully & navigated to home page")
	public void validateSwagAppValidLogin(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password, @Optional("Products") String homePageTextVal) throws Throwable {
		try {
			swagLoginPage = new LoginPage(driver);
			homePgeObj = swagLoginPage.validLogin(userName, password);
			actualResult = homePgeObj.getHomePageText();
			super.logExtentReport("user is able to login successfully:: " + status);

			Assert.assertEquals(actualResult, homePageTextVal, "user is able to login successfully");
		} catch (Exception e) {
			Assert.fail("user is not navigated to home page");
			throw e;
		}
	}

	@Parameters({ "invalidUserName", "wrongPassword" })
	@Test(description = "Validate user is able to login successfully & navigated to home page")
	public void ValidateSwagAppInvalidLogin(@Optional("problem_user") String invalidUserName,
			@Optional("wrongpassword") String wrongPassword) throws Throwable {
		try {
			swagLoginPage = new LoginPage(driver);
			swagLoginPage = swagLoginPage.inValidLogin(invalidUserName, wrongPassword);
			status = swagLoginPage.errorMessageButtonDisplayed();
			super.logExtentReport("Error message is displayed" + status);
			Assert.assertEquals(status, true);
		} catch (Exception e) {
			Assert.fail("user is able to login from invalid crdentials ");
			throw e;
		}
	}
}
