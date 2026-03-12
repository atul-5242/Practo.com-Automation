package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingPageNotification extends BasePage {


public SettingPageNotification(WebDriver driver) {
	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

//	===========================  Test Case 5 : Notification Preference settings  ========================
	
	@FindBy(xpath = "//a[@class='notification_settings']")
	private WebElement NotificationSettingButton;
	
	
	public void ClickOnNotificationSettingButton() {
		elementUtils.clickOnElement(NotificationSettingButton);
	}
	
//	Clicking on Saving checkBox:
	@FindBy(name = "Savings")
	private WebElement SavingcheckBox;
	
	public void ClickOnSavingcheckBox() {
		elementUtils.clickOnElement(SavingcheckBox);
	}
	
	
	
//	Clicking on Informational checkBox:
	@FindBy(name = "Informational")
	private WebElement InformationalCheckBox;
	
	public void ClickOnInformationalCheckBox() {
		elementUtils.clickOnElement(InformationalCheckBox);
	}
	

	
	
//	Clicking on Announcements:
	@FindBy(name = "Announcements")
	private WebElement AnnouncementsCheckBox;
	
	public void ClickOnAnnouncementsCheckBox() {
		elementUtils.clickOnElement(AnnouncementsCheckBox);
	}
	
	
	
//	Clicking on Submit:
	@FindBy(xpath = "//span[@class='submit-button-text bold']")
	private WebElement SubmitButtonForNotification;
	
	public void ClickOnSubmitButtonForNotification() {
		elementUtils.clickOnElement(SubmitButtonForNotification);
	}
	
	
//	Clicking on Success Notification for notification_settings:
	@FindBy(css = ".feedback-span")
	private WebElement SuccessNotificationForsettings;

	public String waitForSuccessMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Wait for the element to be visible
	    wait.until(ExpectedConditions.visibilityOf(SuccessNotificationForsettings));

	    // Wait until the text appears (contains "Thank")
	    wait.until(ExpectedConditions.textToBePresentInElement(
	        SuccessNotificationForsettings, "Thank"
	    ));

	    return SuccessNotificationForsettings.getText().trim();
	}
	
}
