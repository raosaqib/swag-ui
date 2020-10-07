package com.globalkinetic.swaglabs.ui.test.homepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globalkinetic.swaglabs.basics.Basics;
import com.globalkinetic.swaglabs.ui.browserconfig.config.ObjectReader;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.cartpage.CartPage;
import com.globalkinetic.swaglabs.ui.test.helper.wait.WaitHelper;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

/**
 * 
 * @author rao saqib
 *
 */
public class HomePage extends Basics {
	private final Logger log = LoggerHelper.getLogger(HomePage.class);
	WebElement element;
	WaitHelper waithelper;
	boolean status;
	String text;

	@FindBy(how = How.CLASS_NAME, using = "product_label")
	private WebElement homepageProductlabel;
	@FindBy(how = How.CSS, using = ".inventory_item:nth-child(1) .btn_primary")
	private WebElement addFrstItemTocart;
	@FindBy(how = How.ID, using = "shopping_cart_container")
	private WebElement clickOncart;

	public HomePage(WebDriver driver) {
		super(driver);

		log.info("Home page initialization");
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);

		waithelper.waitForElement(homepageProductlabel, ObjectReader.reader.getExplicitWait());

		TestBase.logExtentReport("Home page object is created");
	}

	public String getHomePageText() {
		log.info("Login page text");
		text = super.getText(homepageProductlabel);
		return text;

	}

	public boolean userIsAbleToAddItemToCart() {
		log.info("user is able to add item to cart");
		status = super.clickWebelement(addFrstItemTocart);
		return status;
	}

	public boolean userIsAbleToClickOnCartIcon() {
		log.info("user is able to clickon the cart icon");
		status = super.clickWebelement(clickOncart);
		return status;

	}

	public CartPage UserNavigatesTocartpage() {
		this.userIsAbleToClickOnCartIcon();

		return new CartPage(driver);
	}
}
