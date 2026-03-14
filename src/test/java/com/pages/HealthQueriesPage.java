package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

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
	
	public void ClickSearchInInput() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.className("do-search-enter-submit"))).sendKeys(Keys.ENTER).perform();
	}
	
	
	@FindBy(xpath="//h1[@class='feed-header']")
	private WebElement HeadingVerifyValidSearch;
	
	
	public String getMessageOfSuccessSearch() {
		return elementUtils.getTextFromElemet(HeadingVerifyValidSearch);
	}
	
	
	
	@FindBy(xpath="//p[@class='head']")
	private WebElement HeadingVerifyInValidSearch;
	
	
	public String getMessageOfFaliureSearch() {
		return elementUtils.getTextFromElemet(HeadingVerifyInValidSearch);
	}
	
	@FindBy(xpath="//a[normalize-space()='Brain and Spine']")
	private WebElement TagsOfBrainAndSpineButton;
	
	
	public String ClickTagsOfBrainAndSpineButton() {
		return elementUtils.getTextFromElemet(TagsOfBrainAndSpineButton);
	}

	public void scrollToRequiredBrainTag() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement TagOfBrain = wait.until(ExpectedConditions.visibilityOf(TagsOfBrainAndSpineButton));
		JavascriptExecutor jsdriver = (JavascriptExecutor) driver;
		jsdriver.executeScript("arguments[0].scrollIntoView(true);", TagOfBrain);
		wait.until(ExpectedConditions.elementToBeClickable(TagOfBrain));
	}
	
	public void ClickOnTagBrain() {
		elementUtils.clickOnElement(TagsOfBrainAndSpineButton);
	}
}

