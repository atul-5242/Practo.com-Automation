package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingPageChangePassword extends BasePage {
	WebDriver driver;
	public SettingPageChangePassword(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
//	================================  Test Case 4 : Change Password  ================================
	
	
	@FindBy(css ="#current_password")
	private WebElement CurrentPasswordField;
	
	@FindBy(css="#new_password")
	private WebElement NewPasswordFiled;
	
	@FindBy(css="#confirm")
	private WebElement ConfirmPasswordField;
	
	
	@FindBy(xpath="//input[@id='submit_ch']")
	private WebElement ConfirmButton;
	
	
	
	public void EnterCurrentPasswordText(String CurrentPassword) {
		elementUtils.eneterTextIntoElement(CurrentPasswordField,CurrentPassword);
	}
	
	public void EnterNewPasswordText(String NewPassword) {
		elementUtils.eneterTextIntoElement(NewPasswordFiled,NewPassword);
	}
	public void EnterConfirmPasswordText(String ConfirmPassword) {
		elementUtils.eneterTextIntoElement(ConfirmPasswordField,ConfirmPassword);
	}
	
	public void ClickOnConfirmPasswordButton() {
		elementUtils.clickOnElement(ConfirmButton);
	}
	@FindBy(xpath = "//body/div[@id='spSignup']/div[@id='variableHeightContainer']/div[1]")
	private WebElement SuccessPasswordChange;
	
	public String getTheSuccessMesssageOfPassword() {
		return elementUtils.getTextFromElemet(SuccessPasswordChange);
	}
	
	
	
	
}
