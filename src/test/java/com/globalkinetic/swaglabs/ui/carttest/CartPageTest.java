package com.globalkinetic.swaglabs.ui.carttest;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.cartpage.CartPage;
import com.globalkinetic.swaglabs.ui.test.homepage.HomePage;
import com.globalkinetic.swaglabs.ui.test.loginpage.LoginPage;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

public class CartPageTest extends TestBase {
	private final Logger log = LoggerHelper.getLogger(CartPageTest.class);
	boolean status;
	LoginPage loginpage;
	HomePage homePgeObj;
	CartPage cartpage;
	String actualResult;
	int itemAddedtocart;

	@Parameters({ "userName", "password" })
	@Test(description = "Validate cart has added items")
	public void validateUserisAbleToAddItemToCart(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password) throws Throwable

	{
		try {
			loginpage = new LoginPage(driver);
			homePgeObj = loginpage.validLogin(userName, password);

			homePgeObj.userIsAbleToAddItemToCart();
			homePgeObj.userIsAbleToClickOnCartIcon();
			cartpage = homePgeObj.UserNavigatesTocartpage();
			status = cartpage.itemsAddedInThecart();
			super.logExtentReport("user is able to add item to cart " + status);
			log.info("card has added items");
			assertEquals(status, true);

		} catch (Exception e) {
			Assert.fail("user not navigated to corect application");
			throw e;

		}

	}

	@Parameters({ "userName", "password" })
	@Test(description = "Validate cart has added items")
	public void validateUserisAbleToCheckOutOrders(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password) throws Throwable

	{
		try {
			loginpage = new LoginPage(driver);
			homePgeObj = loginpage.validLogin(userName, password);

			homePgeObj.userIsAbleToAddItemToCart();
			homePgeObj.userIsAbleToClickOnCartIcon();
			cartpage = homePgeObj.UserNavigatesTocartpage();
			log.info("card has added items");
			status = cartpage.clickOnCheckOut();
			super.logExtentReport("user is able to click on the check out button " + status);

			assertEquals(status, true);

		} catch (Exception e) {
			Assert.fail("user not navigated to corect application");
			throw e;

		}

	}

}
