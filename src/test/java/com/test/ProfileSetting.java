package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.EditProfilePage;
import com.pages.LoginPage;
import com.pages.SettingPageChangePassword;
import com.pages.SettingPageNotification;
import com.parameter.DataProviders;
import com.parameter.ExcelReader;
import com.setup.BaseSteps;
import com.setup.Hooks;

public class ProfileSetting extends Hooks{
	
//	@Test(priority=1,dataProvider = "loginCredentialSupplier",dataProviderClass = DataProviders.class)
//	public  void ChangePassowrd(String mobileNumber,String password) throws InterruptedException{
//		
////		======================================  Change Password  ==================================
//		
//		loginPage = new LoginPage(driver);
//		loginPage.LoginButtoOfProfileAndSignup();
//		loginPage.enterMobileNumber(mobileNumber);
//		loginPage.enterPassword("Atul6651@");
//		loginPage.clickOnLoginButton();
//	
//		editProfile = new EditProfilePage(driver);	
//		editProfile.ClickProfileProfilePicOfMainPage();
//		Thread.sleep(1000);
//		editProfile.ClickOnSettingButton();
////		editProfile.ClickEditProfilePicOfEditPage();
//		
//		settingPagePassword = new SettingPageChangePassword(driver);
//		settingPagePassword.EnterCurrentPasswordText("Atul6651@");
//		settingPagePassword.EnterConfirmPasswordText("Atul6652@");
//		settingPagePassword.EnterNewPasswordText("Atul6651@");
//		
//		settingPagePassword.ClickOnConfirmPasswordButton();
//		
//
//		Assert.assertTrue(
//		    settingPagePassword.getTheSuccessMesssageOfPassword().contains("Password updated successfully"),
//		    "Success message text mismatch!"
//		);
//
//	}
	
	
	
	
	
	
	
//	================================  Update Profile  ==================================
	@Test(priority=2)
	public  void UpdateProfileDetails() throws InterruptedException{
		
		
//		======================================    ==================================
		
		String HomeAddress = ExcelReader.getValueByKey("Sheet1","HomeAddress");
		String Colony = ExcelReader.getValueByKey("Sheet1","Colony");
		String City = ExcelReader.getValueByKey("Sheet1","City");
		
		
		editProfile = new EditProfilePage(driver);	
		editProfile.ClickProfileProfilePicOfMainPage();
		
		Thread.sleep(1000);
		
		editProfile.ClickViewAndUpdateProfileButton();
		editProfile.EnterHomeAddressInput(HomeAddress);
		editProfile.EnterColonyInput(Colony);
		editProfile.EnterCityInput(City);
		
		
		
		editProfile.ClickSaveChangeButton();
		
		
		Thread.sleep(2000);
		
		Assert.assertTrue(
			    editProfile.getSuccessAlertOfProfileUpdate().contains("Profile has been updated successfully"),
			    "Success message text mismatch!"
			);

	}
	
	
	

	
//	================================  Update Profile  ==================================
	
	@Test(priority=1)
	public  void NotificationPreferenceChange() throws InterruptedException{
		
		
//		======================================    ==================================
		
		
		
	
		editProfile = new EditProfilePage(driver);	
		editProfile.ClickProfileProfilePicOfMainPage();
		editProfile.ClickOnSettingButton();
		
		Thread.sleep(1000);
		
		editProfile.ClickOnNotificationSetting();
		
		settingNotification = new SettingPageNotification(driver);
		
		
		settingNotification.ClickOnInformationalCheckBox();
		settingNotification.ClickOnAnnouncementsCheckBox();
		settingNotification.ClickOnSavingcheckBox();
		
		settingNotification.ClickOnSubmitButtonForNotification();
		

		String msg = settingNotification.waitForSuccessMessage().trim();
		Assert.assertTrue(msg.contains("Thank you for your feedback"), 
		                  "Success message mismatch! Actual: " + msg);
		
		
	}
	
}
