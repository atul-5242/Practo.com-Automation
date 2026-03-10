package com.utils;



import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickOnElement(WebElement element) {
		if(element.isDisplayed() && element.isEnabled()) {
			element.click();
		}
	}
	
	public void eneterTextIntoElement(WebElement element,String text) {
		if(element.isDisplayed() && element.isEnabled()) {
			element.clear();
			element.sendKeys(text);
		}
	}
	
	public String getTextFromElemet(WebElement element) {
		String text="";
		if(element.isDisplayed())
		{
			text= element.getText();
		}
		return text;
	}
	
	public boolean isElementDisplayed(WebElement element) {
		boolean b = false;
		try {
			b = element.isDisplayed();
		}catch(NoSuchElementException e) {
			e.getStackTrace();
		}
		return b;
	}
}

