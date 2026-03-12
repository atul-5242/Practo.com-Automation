package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.parameter.DataProviders;
import com.setup.BaseSteps;



public class Login extends BaseSteps{

		public WebDriver driver;

		@BeforeMethod
		public void setup() {
			driver = openBrowserAndApplication();
			loginPage= new LoginPage(driver);
		}
		@AfterMethod
		public void closure() {
			driver.quit();
		}
		
		@Test(priority=1,dataProvider = "loginCredentialSupplier",dataProviderClass =DataProviders.class)
		public  void LoginWithValidCredentials(String mobileNumber,String password){
			loginPage = new LoginPage(driver);
			loginPage.LoginButtoOfProfileAndSignup();
			loginPage.enterMobileNumber(mobileNumber);
			loginPage.enterPassword(password);
			loginPage.clickOnLoginButton();
			Assert.assertEquals(loginPage.getNameOfUser(),"Atul Maurya");
		}
	}


