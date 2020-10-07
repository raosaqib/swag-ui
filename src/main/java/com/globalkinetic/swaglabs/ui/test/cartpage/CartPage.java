package com.globalkinetic.swaglabs.ui.test.cartpage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globalkinetic.swaglabs.basics.Basics;
import com.globalkinetic.swaglabs.ui.browserconfig.config.ObjectReader;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.helper.wait.WaitHelper;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

/**
 * 
 * @author rao saqib
 *
 */
public class CartPage extends Basics {
	private final Logger log = LoggerHelper.getLogger(CartPage.class);
	WebElement element;
	WaitHelper waithelper;
	boolean status;
	String textToValidate;
	@FindBy(how = How.CLASS_NAME, using = "subheader")
	private WebElement yourcart;
	@FindBy(how = How.CLASS_NAME, using = "cart_quantity")
	private WebElement cartQuantity;
	// @FindBy(how=How.CLASS_NAME,using="btn_action checkout_button")
	@FindBy(how = How.LINK_TEXT, using = "CHECKOUT")
	private WebElement checkOut;

	public CartPage(WebDriver driver) {
		super(driver);

		log.info("Login page initialization");
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);

		waithelper.waitForElement(yourcart, ObjectReader.reader.getExplicitWait());

		TestBase.logExtentReport("cartpage object is created");
	}

	public String getSubHeaderTextOfThecartpage() {
		textToValidate = super.getText(yourcart);
		return textToValidate;
	}

	public boolean itemsAddedInThecart() {
		String cardQuan = super.getText(cartQuantity);

		int count = Integer.parseInt(cardQuan);
		if (count > 0) {
			return true;
		} else
			return false;

	}

	public boolean clickOnCheckOut() {
		log.info("user is checking out from cart  page");
		return status = super.clickWebelement(checkOut);
	}

}
