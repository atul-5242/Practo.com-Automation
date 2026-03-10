package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
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
		
		@Test(priority=1,dataProvider = "loginCredentialSupplier",dataProviderClass =DataProvider.class)
		public  void LoginWithValidCredentials(String mobileNumber,String password){
			loginPage = new LoginPage(driver);
//			login.enterEmail(prop.getProperty("validEmail"));
			loginPage.enterMobileNumber(mobileNumber);
//			login.enterPassword(prop.getProperty("validPassword"));
			loginPage.enterPassword(password);
			loginPage.clickOnLoginButton();
			Assert.assertEquals(loginPage.getNameOfUser(),"Atul Maurya");
		}
	}


