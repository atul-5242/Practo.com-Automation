package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
	
	

	
	
	
	
//	---------------1st Step of Payment------------ Step of Payment through Specific Symptoms ------------- 
	
	
	
	
	
	
	
	

// ------------------------------------------------------------------------------------
	
	
	
//	================================  Test Case 3:  ===========================
	
	
	
//	-------------1st Step of Payment-------------- PAYMENT PAGE Based on Generic Data --------------------------------
	
	
	
	@FindBy(xpath="//textarea[@id='detailed-description']")
	private WebElement TextFieldOfSymptom;
	
	public void EnterOnTextFieldSymptoms(String symptoms) {
		elementUtils.eneterTextIntoElement(TextFieldOfSymptom,symptoms);
	}
	
	
	@FindBy(xpath="//label[@for='problemArea_17']")
	private WebElement PrediatricsButton;
	
	public void ClickOnPrediatricsButton() {
		elementUtils.clickOnElement(PrediatricsButton);
	}
	
	@FindBy(xpath="//button[@class='btn-blue continue-btn']")
	private WebElement ContinueButtonOnNewConsult;
	
	public void ClickOnContinueButtonOnNewConsult() {
		elementUtils.clickOnElement(ContinueButtonOnNewConsult);
	}
	
	
//	-------------------------------[ 2nd Step in Payment Page ]---------------------

	@FindBy(xpath="//span[@class='ng-binding']")
	private WebElement ContinueButtonOnPayment;
	
	public void ClickOnButtonContinueToPayemnt() {		
		elementUtils.clickOnElement(ContinueButtonOnPayment);
	}
	
	
//	This will fill the payment text field.
	
	@FindBy(xpath="//input[@id='card-number']")
	private WebElement CardNumber;
	
	
	@FindBy(xpath="//input[@id='name-on-card']")
	private WebElement NameOnCard;
	
	
	@FindBy(xpath="//input[@id='valid-upto']")
	private WebElement vaildUpto;
	
	@FindBy(xpath="//input[@id='cvv']")
	private WebElement CVVField;

	
	@FindBy(xpath="//div[@id='pay-now']")
	private WebElement PayNowField;
	
	public void ClickOnPayNowField() {		
		elementUtils.clickOnElement(PayNowField);
	}
	
	public void EnterOnCVVField() {		
		elementUtils.clickOnElement(CVVField);
	}
	
	public void EnterOnvaildUpto() {		
		elementUtils.clickOnElement(vaildUpto);
	}
	public void EnterOnNameOnCard() {		
		elementUtils.clickOnElement(NameOnCard);
	}
	
	public void EnterOnCardNumber() {		
		elementUtils.clickOnElement(CardNumber);
	}
	
	
	
	
	
//	Final Pay Button :
	
	@FindBy(xpath="//label[contains(@class,'checked-box domestic')]")
	private WebElement IndiaFiledButtonRS;
	
	public void ClickOnIndiaFiledButtonRS() {		
		elementUtils.clickOnElement(IndiaFiledButtonRS);
	}
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement PayRSPayment;
	
	public void ClickOnPayRS() {		
		elementUtils.clickOnElement(PayRSPayment);
	}
	
	@FindBy(xpath="//div[normalize-space()='Payment Failed']")
	private WebElement PaymentFailedText;
	
	public String PaymentFailedPopUP() {
		return elementUtils.getTextFromElemet(PaymentFailedText);
	}
}