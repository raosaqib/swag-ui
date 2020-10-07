package com.globalkinetic.swaglabs.ui.test.loginpage;

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
import com.globalkinetic.swaglabs.ui.test.homepage.HomePage;
import com.globalkinetic.swaglabs.ui.testbase.TestBase;

public class LoginPage extends Basics {

	private final Logger log = LoggerHelper.getLogger(LoginPage.class);
	WebElement element;
	WaitHelper waithelper;
	String textToValidate;
	boolean status;
	@FindBy(how = How.CLASS_NAME, using = "login_logo")
	private WebElement loginPageLogo;
	@FindBy(how = How.ID, using = "user-name")
	private WebElement uname;
	@FindBy(how = How.ID, using = "password")
	private WebElement pwd;
	@FindBy(how = How.ID, using = "login-button")
	private WebElement login;
	@FindBy(how = How.CLASS_NAME, using = "error-button")
	private WebElement errorBtn;
	public LoginPage(WebDriver driver) {
		super(driver);
		log.info("Login page initialization");
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);

		waithelper.waitForElement(loginPageLogo, ObjectReader.reader.getExplicitWait());

		TestBase.logExtentReport("login page object is created");
	}

	public String getApplicationTitle() {
		String appltitle = super.getAppTitle();
		log.info("application title loaded" + appltitle);
		return appltitle;
	}
	public void enterUserName(String uname) {
		log.info("Entering  the username");
		status = super.findElementAndFillText(this.uname, uname);
	}
public void enterPassword(String pwd) {
		log.info("Entering  the password");
		status = super.findElementAndFillText(this.pwd, pwd);
	}

	public boolean clickOnSignIn() {
		log.info("clicking on signin button");
		status = super.clickWebelement(login);
		return status;
	}

	public HomePage validLogin(String uName, String pwd) {
		log.info("validate user is ");
		this.enterUserName(uName);
		this.enterPassword(pwd);
		this.clickOnSignIn();
		return new HomePage(driver);
	}
	public LoginPage inValidLogin(String uName, String pwd) {
		this.enterUserName(uName);
		this.enterPassword(pwd);
		this.clickOnSignIn();
		return this;
	}

	public String getApplicationLogo() {
		element = super.getElement(loginPageLogo);
		textToValidate = element.getAttribute("class");
		return textToValidate;
	}
	public boolean errorMessageButtonDisplayed() {
		return super.isDsiplayed(errorBtn);
	}
}