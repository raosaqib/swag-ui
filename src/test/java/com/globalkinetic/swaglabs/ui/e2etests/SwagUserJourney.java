package com.globalkinetic.swaglabs.ui.e2etests;

import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.globalkinetic.swaglabs.ui.test.cartpage.CartPage;
import com.globalkinetic.swaglabs.ui.test.homepage.HomePage;
import com.globalkinetic.swaglabs.ui.test.loginpage.LoginPage;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

public class SwagUserJourney extends TestBase {
	boolean status;
	String actualResult;
	LoginPage swagLoginPage;
	HomePage homePgeObj;
	CartPage cartpage;
	SoftAssert soft = new SoftAssert();

	@Parameters({ "title", "userName", "password", "homePageTextVal" })
	@Test(description = "validate user is able to login and able to add item to cart and able to click on checkout", priority = 10)
	public void validateuserIsAbleToLoginToAppAndAbleToCheckOut(@Optional("Swag Labs") String appTitle,
			@Optional("standard_user") String userName, @Optional("secret_sauce") String password,
			@Optional("Products") String homePageTextVal) throws Throwable {
		try {
			swagLoginPage = new LoginPage(driver);
			actualResult = swagLoginPage.getApplicationTitle();
			soft.assertEquals(actualResult, appTitle);
			super.logExtentReport("Actual title of the application is::  " + actualResult);
			homePgeObj = swagLoginPage.validLogin(userName, password);
			actualResult = homePgeObj.getHomePageText();
			super.logExtentReport("User is navigated to home page:: " + actualResult);
			soft.assertEquals(actualResult, homePageTextVal, "user is navigated to right application");

			// ========================= navigation to next page starts============//
			status = homePgeObj.userIsAbleToAddItemToCart();
			soft.assertEquals(status, true);
			super.logExtentReport("user is able to add product to cart:: " + status);
			status = homePgeObj.userIsAbleToClickOnCartIcon();
			soft.assertEquals(status, true, "User is able to click on the cart icon");
			super.logExtentReport("User is able to click on the cart icon:: " + status);
			// ========================= navigation to next page starts============//
			cartpage = homePgeObj.UserNavigatesTocartpage();
			super.logExtentReport("user is navigated to cart page:: " + cartpage);

			status = cartpage.clickOnCheckOut();
			soft.assertEquals(status, true);
			super.logExtentReport("user is able to click on the check out button:: " + status);
			soft.assertAll();
		} catch (Exception e) {
			Assert.fail("user not navigated to corect application");
			throw e;

		}
	}

}
