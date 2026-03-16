package com.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.PaymentPage;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.setup.Hooks;

public class VideoConsult extends Hooks {
	
	

	
//	================================  VideoConsultToDoctorPayment  ==================================
	@Test(priority=1, dataProvider = "cardData", dataProviderClass = DataProviders.class)
	public  void VideoConsultToDoctorPayment(String cardNumber, String cardHolderName) throws InterruptedException{
		
		//		======================================    ==================================
		
		/*
			Created By : Atul Maurya
			SME Name : Vineel Kumar, Manchikatla
			Test Description : Video Call Consult To Doctor and trying to do Payment.
		 */
		
		
		videoConsult = new VideoConsultPage(driver);
		
		videoConsult.ClickOnVideoConsultButton();
		videoConsult.ClickOnConsultNowButton();
		
		paymentStep = new PaymentPage(driver);
		paymentStep.EnterOnTextFieldSymptoms("fever");
		
		Thread.sleep(3000);
		
		paymentStep.ClickOnPrediatricsButton();
		paymentStep.ClickOnContinueButtonOnNewConsult();
		paymentStep.ClickOnButtonContinueToPayemnt();		
		
		paymentStep.EnterOnCardNumber(cardNumber);
		paymentStep.EnterOnNameOnCard(cardHolderName);
		paymentStep.EnterOnCVVField(prop.getProperty("EnterCVV"));
		paymentStep.EnterOnvaildUpto(prop.getProperty("VaildUpto"));
		
		
		Thread.sleep(3000);
		paymentStep.ClickOnPayRS();
		Thread.sleep(10000);
//		paymentStep.ClickOnIndiaFiledButtonRS();
//		
//		paymentStep.ClickOnPayNowField();
		
		Assert.assertTrue(
					!paymentStep.PaymentFailedPopUP().contains("Payment Failed"),
		    "Success message text mismatch!"
		);

}
}