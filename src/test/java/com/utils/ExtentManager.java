package com.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;

public class ExtentManager {

	public static ExtentReports generateExtentReport() {
		 
		ExtentReports extentReports = new ExtentReports();
 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "\\Reports\\extentReport.html"));
		ExtentSparkReporterConfig sparkReportConfig = sparkReporter.config();
		sparkReportConfig.setDocumentTitle("TutorialsNinja Report");
		sparkReportConfig.setReportName("TN Test Results");
 
		extentReports.attachReporter(sparkReporter);

		extentReports.setSystemInfo("Username", "Atul Maurya");
		extentReports.setSystemInfo("Selenium Version", "4.40.0");
		extentReports.setSystemInfo("Operating System", "Windows 11");
 
		return extentReports;
 
	}
}