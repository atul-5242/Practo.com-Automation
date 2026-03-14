package com.parameter;
import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="loginCredentialSupplier")
	public Object[][] supplyAccountCredentials(){
		Object[][] data = {{"6398330350","Atul8872@"}};
		return data;
	}
}