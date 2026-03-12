package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoConsultPage  extends BasePage{

	
	public VideoConsultPage(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);

	}
	
	
//	Below Locators help to redirect to the payment page:

	@FindBy(xpath="//div[@class='product-tab__title'][normalize-space()='Video Consult']")
	private WebElement VideoConsultButton;
	
	public void ClickOnVideoConsultButton() {
		elementUtils.clickOnElement(VideoConsultButton);
	}

	@FindBy(xpath="//div[@class='content']//a[@class='link primary-button cta'][normalize-space()='Consult Now']")
	private WebElement ConsultNowButton;
	
	public void ClickOnConsultNowButton() {
		elementUtils.clickOnElement(ConsultNowButton);
	}
	
	
	
//	-------------------- Below is for Redirecting to the Health Query page -----------------
	
	@FindBy(xpath ="(//a[@class='link health-query__link'])[1]")
	private WebElement ReadMoreButtonForHealthQueries;
	

	
	
	
	public void scrollToRequiredReadMore() {
		JavascriptExecutor jsdriver=(JavascriptExecutor)driver;
		WebElement TitleOfHealthQueries= driver.findElement(By.xpath("//h2[normalize-space()='Health Queries']"));
		jsdriver.executeScript("arguments[0].scrollIntoView(true);",TitleOfHealthQueries);
	}
	
	
	public void ClickOnReadMoreButtonForHealthQueries() {

		elementUtils.clickOnElement(ReadMoreButtonForHealthQueries);
	}
	
	
	
	
}
