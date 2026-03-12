package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage extends BasePage{
	WebDriver driver;
	public EditProfilePage(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
	
//	======================== Test Case 2 : Edit Profile ============================	
	
	@FindBy(xpath="//span[@class='up-triangle']//span[@class='user_info_top'][normalize-space()='Atul Maurya']")
	private WebElement ProfileDropDown;
	
	public void ClickProfileProfilePicOfMainPage() {
		elementUtils.clickOnElement(ProfileDropDown);
	}
	
	
	@FindBy(xpath="//div[@class='navbar desktop en']//div[8]//a[1]")
	private WebElement ViewAndUpdateProfileButton;
	
	public void ClickViewAndUpdateProfileButton() {
		elementUtils.clickOnElement(ViewAndUpdateProfileButton);
	}
	
	
	@FindBy(xpath="//li[@data-position='bottom']//img[@class='pnav-user-pic']")
	private WebElement EditProfilePicOfEditPage;
	
	public void ClickEditProfilePicOfEditPage() {
		elementUtils.clickOnElement(EditProfilePicOfEditPage);
	}
	
	
	@FindBy(xpath="//li[@class='top-nav-item open']//a[@class='pnav-accts-button pnav-my-account-button'][normalize-space()='Account']")
	private WebElement AccountButtonInDropDown;
	
	public void ClickAccountButtonInDropDown() {
		elementUtils.clickOnElement(AccountButtonInDropDown);
	}
	
	@FindBy(xpath="//input[@id='street_address']")
	private WebElement HomeAddressInput;
	
	public void EnterHomeAddressInput(String address) {
		elementUtils.eneterTextIntoElement(HomeAddressInput,address);
	}
	
	@FindBy(xpath="//input[@id='locality']")
	private WebElement ColonyInput;
	
	public void EnterColonyInput(String colony) {
		elementUtils.eneterTextIntoElement(ColonyInput,colony);
	}
	@FindBy(xpath="//input[@id='city']")
	private WebElement CityInput;
	
	public void EnterCityInput(String city) {
		elementUtils.eneterTextIntoElement(CityInput,city);
	}
	@FindBy(xpath="//button[@class='c-button c-button--primary c-button--md']")
	private WebElement SaveChangeButton;
	
	public void ClickSaveChangeButton() {
		elementUtils.clickOnElement(SaveChangeButton);
	}
	
	
	@FindBy(xpath="//span[@class='noty_text']")
	private WebElement SuccessAlertOfProfileUpdate;
	
	public String getSuccessAlertOfProfileUpdate() {
		return elementUtils.getTextFromElemet(SuccessAlertOfProfileUpdate);
	}
	
	
	@FindBy(linkText ="Settings")
	private WebElement AccountSettingButton;
	
	public void ClickOnSettingButton() {
		elementUtils.clickOnElement(AccountSettingButton);
	}
	@FindBy(xpath="//a[@class='notification_settings']")
	private WebElement NotificationSettingButton;
	
	public void ClickOnNotificationSetting() {
		elementUtils.clickOnElement(NotificationSettingButton);
	}
	
}
