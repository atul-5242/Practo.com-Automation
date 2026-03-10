package com.setup;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.pages.LoginPage;
import com.parameter.PropertyReader;



public class BaseSteps {

		public Properties prop;
		WebDriver driver;
//		public HomePage homePage;
		public LoginPage loginPage;

		
		public WebDriver openBrowserAndApplication() {
			
			prop = PropertyReader.loadPropertiesOfxFile();
			String browser = prop.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {
			    driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("firefox")) {
			    driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
			    driver = new EdgeDriver();

			} else if (browser.equalsIgnoreCase("safari")) {
			    driver = new SafariDriver();

			} else {
			    System.out.println("Invalid browser name in properties file!");
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();

			driver.get(prop.getProperty("URL"));
			
			return driver;
		}
	}



