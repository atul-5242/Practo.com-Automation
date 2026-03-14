package com.parameter;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReader {

	public static Properties loadPropertiesOfFile() {
		Properties prop=  new Properties();
		try {
			FileInputStream fs= new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//PropertyData//property.properties");
			prop.load(fs);	
			fs.close();
		}
		catch (Exception e) {
			System.err.println("Error loading property file: " + e.getMessage());
			e.printStackTrace();
		}
		return prop;
	}
}
