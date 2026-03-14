package com.setup;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.pages.EditProfilePage;
import com.pages.HealthQueriesPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.SettingPageChangePassword;
import com.pages.SettingPageNotification;
import com.pages.VideoConsultPage;



public class Hooks extends BaseSteps{
	
	public WebDriver driver;
	public LoginPage loginPage;
	public SettingPageChangePassword settingPagePassword;
	public SettingPageNotification settingNotification;
	public VideoConsultPage videoConsult;
	public HealthQueriesPage healthQueries;
	public EditProfilePage editProfile;
	public PaymentPage paymentStep;
	
//	@Parameters("browser")
	@BeforeMethod
//	public void setup(String browser) {
	public void setup() {
//		driver = openApplication(browser);
		driver = openBrowserAndApplication();
		
		loginPage = new LoginPage(driver);
		loginPage.LoginButtoOfProfileAndSignup();
		loginPage.enterMobileNumber(prop.getProperty("MobileNumber"));
		loginPage.enterPassword(prop.getProperty("CurrPassword"));
		loginPage.clickOnLoginButton();

	}
	
	@AfterMethod
	public void closure() {
		driver.quit();
	}
}
