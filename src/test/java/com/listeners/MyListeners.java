package com.listeners;
 
import org.openqa.selenium.WebDriver;

import org.testng.ITestContext;

import org.testng.ITestListener;

import org.testng.ITestResult;
 
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;

import com.utils.ExtentManager;

import com.utils.Screenshots;
 
 
public class MyListeners implements ITestListener {
 
	ExtentReports extentReport;

	ExtentTest extentTest;

	WebDriver driver ;

	@Override

	public void onTestStart(ITestResult result) {

		String testname = result.getName();

		extentTest = extentReport.createTest(testname);

	}
 
	@Override

	public void onTestSuccess(ITestResult result) {

		extentTest.log(Status.PASS, result.getName()+" got passed.");

	}
 
	@Override

	public void onTestFailure(ITestResult result) {

		extentTest.log(Status.FAIL, result.getName()+" got failed.");

		try {

			driver  = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());

		} catch(Exception e) {

			e.printStackTrace();

		}

		String ScreenshotPath = Screenshots.takeScreenshot(driver, result.getName());

		extentTest.addScreenCaptureFromPath(ScreenshotPath);

	}
 
	@Override

	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.SKIP, result.getName()+" got skipped.");
 
	}
 
	@Override

	public void onStart(ITestContext context) {

		extentReport = ExtentManager.generateExtentReport();

	}
 
	@Override

	public void onFinish(ITestContext context) {

		extentReport.flush();

	}

}

 