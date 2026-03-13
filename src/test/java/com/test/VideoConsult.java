package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EditProfilePage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.SettingPageChangePassword;
import com.pages.SettingPageNotification;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.parameter.PropertyReader;
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
	

	
//	================================  Update Profile  ==================================
	@Test(priority=1,dataProvider = "loginCredentialSupplier",dataProviderClass = DataProviders.class)
	public  void VideoConsultToDoctorPayment(String mobileNumber,String password) throws InterruptedException{
		
		//		======================================    ==================================
		
		prop = PropertyReader.loadPropertiesOfFile();
		
		loginPage = new LoginPage(driver);
		loginPage.LoginButtoOfProfileAndSignup();
		loginPage.enterMobileNumber(mobileNumber);
		loginPage.enterPassword("Atul6651@");
		loginPage.clickOnLoginButton();
		
		videoConsult = new VideoConsultPage(driver);
		
		videoConsult.ClickOnVideoConsultButton();
		videoConsult.ClickOnConsultNowButton();
		
		paymentStep = new PaymentPage(driver);
		paymentStep.EnterOnTextFieldSymptoms("fever");
		
		Thread.sleep(3000);
		
		paymentStep.ClickOnPrediatricsButton();
		paymentStep.ClickOnContinueButtonOnNewConsult();
		paymentStep.ClickOnButtonContinueToPayemnt();		
		
		paymentStep.EnterOnCardNumber(prop.getProperty("CardNumber"));
		paymentStep.EnterOnNameOnCard(prop.getProperty("CardHolderName"));
		paymentStep.EnterOnCVVField(prop.getProperty("EnterCVV"));
		paymentStep.EnterOnvaildUpto(prop.getProperty("VaildUpto"));
		
		
		Thread.sleep(3000);
		paymentStep.ClickOnPayRS();
		Thread.sleep(10000);
//		paymentStep.ClickOnIndiaFiledButtonRS();
//		
//		paymentStep.ClickOnPayNowField();
		
		Assert.assertTrue(
					paymentStep.PaymentFailedPopUP().contains("Payment Failed"),
		    "Success message text mismatch!"
		);

}
}