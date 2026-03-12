package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HealthQueriesPage extends BasePage {
	
	WebDriver driver;
	
	public HealthQueriesPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);
	}
	
	
//	============================= Test Case 2 : Valid Search ===============================
	
	@FindBy(xpath="//input[@placeholder='Search by problem or symptom...']")
	private WebElement SeachTextFiled;
	
	public void EnterSearchQuery(String query) {
		elementUtils.eneterTextIntoElement(SeachTextFiled, query);
	}
	
	
	@FindBy(xpath="//i[@id='search-indicator']")
	private WebElement SearchLogo;
	
	public void EnterSearchQuery() {
		elementUtils.clickOnElement(SearchLogo);
	}
	
	
	@FindBy(xpath="//h1[@class='feed-header']")
	private WebElement HeadingVerifyValidSearch;
	
	
	public String getMessageOfSuccessSearch() {
		return elementUtils.getTextFromElemet(HeadingVerifyValidSearch);
	}
}

