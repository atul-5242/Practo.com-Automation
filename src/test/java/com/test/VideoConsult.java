package com.test;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.PaymentPage;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.setup.Hooks;

public class VideoConsult extends Hooks {
	
	

	
//	================================  VideoConsultToDoctorPayment  ==================================
	@Test(priority=1)
	public  void VideoConsultToDoctorPayment() throws InterruptedException{
		
		//		======================================    ==================================
		
		
		
		
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
					!paymentStep.PaymentFailedPopUP().contains("Payment Failed"),
		    "Success message text mismatch!"
		);

}
}