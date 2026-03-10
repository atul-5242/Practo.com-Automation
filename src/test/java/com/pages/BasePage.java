package com.pages;

import org.openqa.selenium.WebDriver;

import com.utils.ElementUtils;

public class BasePage {
	WebDriver driver;
	
	public ElementUtils elementUtils;
	
	public BasePage(WebDriver driver) {
		this.driver= driver;
		elementUtils = new ElementUtils(driver);
	}
}