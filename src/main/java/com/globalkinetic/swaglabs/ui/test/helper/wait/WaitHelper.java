package com.globalkinetic.swaglabs.ui.test.helper.wait;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		log.info("WaitHelper object created..");
	}

	/**
	 * This is ImplicitWait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	public void pageLoadTime(long timeout, TimeUnit unit) {
		log.info("waiting for page to load for : " + unit + " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}

	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(element));

		log.info("element is visible now" + ele);
	}
}
