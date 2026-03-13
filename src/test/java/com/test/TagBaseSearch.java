package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.setup.BaseSteps;

public class TagBaseSearch extends BaseSteps{
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = openBrowserAndApplication();

	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider = "loginCredentialSupplier",dataProviderClass = DataProviders.class)
	public void SearchHealthQueries(String mobileNumber,String password) throws InterruptedException{
		
//		======================================    ==================================
		
		loginPage = new LoginPage(driver);
		loginPage.LoginButtoOfProfileAndSignup();
		loginPage.enterMobileNumber(mobileNumber);
		loginPage.enterPassword("Atul6651@");
		loginPage.clickOnLoginButton();
			
		videoConsult = new VideoConsultPage(driver);
		
		videoConsult.ClickOnVideoConsultButton();
		
		videoConsult.scrollToRequiredReadMore();
		
		Thread.sleep(2000);
		
		videoConsult.ClickOnReadMoreButtonForHealthQueries();
		
		// initialize healthQueries page object after navigation to health queries section/page
		healthQueries = new com.pages.HealthQueriesPage(driver);

		healthQueries.EnterSearchQuery("Heart");
		
		
		healthQueries.ClickSearchInInput();
		
		healthQueries.scrollToRequiredBrainTag();
		
		healthQueries.ClickOnTagBrain();
		
		Thread.sleep(5000);

		Assert.assertTrue(
				healthQueries.getMessageOfSuccessSearch().contains("Recently Answered Questions on"),
		    "Success message text mismatch!"
		
		);

	}
	
}
