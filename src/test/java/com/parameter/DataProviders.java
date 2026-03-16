package com.parameter;
import org.testng.annotations.DataProvider;

public class DataProviders {

	// Data provider for card details
		@DataProvider(name="cardData")
		public Object[][] supplyCardData(){
			Object[][] data = {
				{"4111111111111111", "John Doe"},  // Sample card number and holder name
				{"4222222222222222", "Jane Smith"} // Another set
			};
			return data;
	}
}