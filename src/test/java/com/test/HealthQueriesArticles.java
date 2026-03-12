package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EditProfilePage;
import com.pages.LoginPage;
import com.pages.SettingPageChangePassword;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.setup.BaseSteps;

public class HealthQueriesArticles extends BaseSteps{
	
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
	public  void SearchHealthQueries(String mobileNumber,String password) throws InterruptedException{
		
//		======================================    ==================================
		
		loginPage = new LoginPage(driver);
		loginPage.LoginButtoOfProfileAndSignup();
		loginPage.enterMobileNumber(mobileNumber);
		loginPage.enterPassword("Atul6651@");
		loginPage.clickOnLoginButton();
			
		videoConsult = new VideoConsultPage(driver);
		
		videoConsult.ClickOnVideoConsultButton();
		
		Thread.sleep(3000);
		videoConsult.scrollToRequiredReadMore();
		
		videoConsult.ClickOnReadMoreButtonForHealthQueries();
		
		healthQueries.EnterSearchQuery("Heart");

		Assert.assertTrue(
				healthQueries.getMessageOfSuccessSearch().contains("Recently Answered Questions on"),
		    "Success message text mismatch!"
		);

	}
	
	
	
}
