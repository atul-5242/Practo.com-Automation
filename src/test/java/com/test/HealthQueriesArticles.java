package com.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.VideoConsultPage;
import com.parameter.ExcelReader;
import com.setup.Hooks;

public class HealthQueriesArticles extends Hooks{
	
	//public WebDriver driver;
	@Test(priority=1)
	public void SearchHealthQueries() throws InterruptedException{
		
		
//		======================================  Test 1  ==================================
		
		/*
			Created By : Atul Maurya
			SME Name : Vineel Kumar, Manchikatla
			Test Description : Search Health Queries With vaild Data.
		 */
		String ValidSearchData = ExcelReader.getValueByKey("Sheet1","VaildSearchQuery");

		videoConsult = new VideoConsultPage(driver);
		videoConsult.ClickOnVideoConsultButton();
		videoConsult.scrollToRequiredReadMore();
		Thread.sleep(2000);
		videoConsult.ClickOnReadMoreButtonForHealthQueries();
		
		// initialize healthQueries page object after navigation to health queries section/page
		healthQueries = new com.pages.HealthQueriesPage(driver);
		healthQueries.EnterSearchQuery(ValidSearchData);
		
		healthQueries.ClickSearchInInput();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(
				healthQueries.getMessageOfSuccessSearch().contains("Recently Answered Questions on"),
		    "Success message text mismatch!"
		);

	}
	
	@Test(priority=2)
	public void InvalidSearchHealthQueries() throws InterruptedException{

		/*
			Created By : Atul Maurya
			SME Name : Vineel Kumar, Manchikatla
			Test Description : Search Health Queries With Invaild Data.
		 */
		
		String InVaildSearchData = ExcelReader.getValueByKey("Sheet1","InVaildSearchQuery");
		
		videoConsult = new VideoConsultPage(driver);
		videoConsult.ClickOnVideoConsultButton();
		videoConsult.scrollToRequiredReadMore();
		Thread.sleep(2000);
		
		videoConsult.ClickOnReadMoreButtonForHealthQueries();
		
		// initialize healthQueries page object after navigation to health queries section/page
		healthQueries = new com.pages.HealthQueriesPage(driver);
		healthQueries.EnterSearchQuery(InVaildSearchData);
		healthQueries.ClickSearchInInput();
		
		System.out.print("-----------------------------------"+healthQueries.getMessageOfFaliureSearch());
		Thread.sleep(2000);
		Assert.assertTrue(
				healthQueries.getMessageOfFaliureSearch().contains("We could not find a match for your search"),
		    "Success message text mismatch!"
		);
	}
}
