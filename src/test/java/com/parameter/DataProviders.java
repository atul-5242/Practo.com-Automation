package com.parameter;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="loginCredentialSupplier")
	public Object[][] supplyAccountCredentials(){
		Object[][] data = {{"6306128371","Atul88772@"}};
		return data;
	}
}
