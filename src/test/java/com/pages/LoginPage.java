package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@name='Practo login']")
	private WebElement LoginButtonOfProfile;
	
	@FindBy(xpath="//input[@id='username']")
	private WebElement MobileNumberInput;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement passwordFieldInput;
	
	@FindBy(xpath="//button[@id='login']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "//span[@class='up-triangle']//span[@class='user_info_top'][normalize-space()='Atul Maurya']" )
	private WebElement NameOfUserInTextField;
	
	
	public String getNameOfUser() {
		return elementUtils.getTextFromElemet(NameOfUserInTextField);
	}
	
	
	public void LoginButtoOfProfileAndSignup() {
//		return notLoggedDisplay.isDisplayed();
		elementUtils.clickOnElement(LoginButtonOfProfile);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		elementUtils.eneterTextIntoElement(MobileNumberInput, mobileNumber);
	}
	public void enterPassword(String password) {
		elementUtils.eneterTextIntoElement(passwordFieldInput, password);
	}
	
	public void clickOnLoginButton() {
		elementUtils.clickOnElement(LoginButton);	
	}

}
