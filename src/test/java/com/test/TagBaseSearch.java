package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.VideoConsultPage;
import com.parameter.DataProviders;
import com.parameter.ExcelReader;
import com.setup.BaseSteps;
import com.setup.Hooks;

public class TagBaseSearch extends Hooks{
	
	
	@Test(priority=1)
	public void SearchHealthQueries() throws InterruptedException{
		
//		======================================    ==================================
		
		String tag = ExcelReader.getValueByKey("Sheet1","tag");
			
		videoConsult = new VideoConsultPage(driver);
		
		videoConsult.ClickOnVideoConsultButton();
		
		videoConsult.scrollToRequiredReadMore();
		
		Thread.sleep(2000);
		
		videoConsult.ClickOnReadMoreButtonForHealthQueries();
		
		// initialize healthQueries page object after navigation to health queries section/page
		healthQueries = new com.pages.HealthQueriesPage(driver);

		healthQueries.EnterSearchQuery(tag);
		
		
		healthQueries.ClickSearchInInput();
		
		healthQueries.scrollToRequiredBrainTag();
		
		healthQueries.ClickOnTagBrain();
		
		Thread.sleep(5000);

		Assert.assertTrue(
				healthQueries.getMessageOfSuccessSearch().contains("Brain and Spine Problems"),
		    "Success message text mismatch!"
		
		);

	}
	
}
