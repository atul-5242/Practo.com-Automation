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
import com.setup.Hooks;



public class Login extends Hooks{
		
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


