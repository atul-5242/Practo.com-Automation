package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.setup.BaseSteps;

public class VideoConsult extends BaseSteps {
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplication();

	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
	
	
	
}