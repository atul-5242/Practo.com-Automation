package com.setup;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;

import com.pages.EditProfilePage;
import com.pages.HealthQueriesPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.SettingPageChangePassword;
import com.pages.SettingPageNotification;
import com.pages.VideoConsultPage;
import com.parameter.PropertyReader;



public class BaseSteps {

		public Properties prop;
		WebDriver driver;
		
		
//		@Parameters("browser")
//		public WebDriver openApplication(String browser) {
		public WebDriver openBrowserAndApplication() {
			
			prop = PropertyReader.loadPropertiesOfFile();
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



