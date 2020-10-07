package com.globalkinetic.swaglabs.ui.homepagetest;

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

public class HomePageTest extends TestBase {

	boolean status;
	LoginPage loginpage;
	HomePage homePgeObj;
	CartPage cartpage;
	String actualResult;
	private final Logger log = LoggerHelper.getLogger(HomePageTest.class);

	@Parameters({ "userName", "password" })
	@Test(description = "Validate user is able to add an item to the cart")
	public void validateUserisAbleToAddItemToCart(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password) throws Exception

	{
		try {
			loginpage = new LoginPage(driver);
			homePgeObj = loginpage.validLogin(userName, password);
			status = homePgeObj.userIsAbleToAddItemToCart();
			super.logExtentReport("user is able to add item to cart " + status);
			assertEquals(status, true);

		} catch (Exception e) {
			Assert.fail("user is not able to add item to cart");
			throw e;
		}

	}

	@Parameters({ "userName", "password" })
	@Test(description = "Validate user is able to click on the cart and navigated to cart page")
	public void validateUserIsAbleToClickOnCart(@Optional("standard_user") String userName,
			@Optional("secret_sauce") String password) throws Throwable

	{
		try {

			loginpage = new LoginPage(driver);
			// homePgeObj= new HomePage(driver);
			homePgeObj = loginpage.validLogin(userName, password);
			homePgeObj.userIsAbleToAddItemToCart();

			cartpage = homePgeObj.UserNavigatesTocartpage();
			actualResult = cartpage.getSubHeaderTextOfThecartpage();
			super.logExtentReport("user is able to navigateto cart " + actualResult);

			assertEquals(actualResult, "Your Cart");
		} catch (Exception e) {
			Assert.fail("user is not able to click on the cart");
			throw e;
		}

	}

}
