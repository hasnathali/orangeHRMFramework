package com.ogarngesHRM.listener;

import java.io.IOException;
import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.ogarngesHRM.utility.Utility;

public class ExtentTestNGITestListener implements ITestListener {

	ExtentReports extent = ExtentManager.getInstance();
	ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	// private static ThreadLocal test = new ThreadLocal();

	public synchronized void onStart(ITestContext context) {
		// ExtentTest parent = extent.createTest(getClass().getName());
		// parentTest.set(parent);
	}

	public synchronized void onFinish(ITestContext context) {
		System.out.println("*****All Test are done. Generating the report.******");
		extent.flush();
		System.out.println("*****Report Generated******");
	}

	public synchronized void onTestStart(ITestResult result) {
		// ExtentTest child =
		// parentTest.get().createNode(result.getMethod().getMethodName());
		// test.set(child);
		System.out.println("Report Generated for: " + result.getMethod().getMethodName());
		// We create report name get methods name for report name
		ExtentTest parent = extent.createTest(result.getMethod().getMethodName());
		parentTest.set(parent);
	}

	// IF pass the test
	public synchronized void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getMethod().getMethodName());
		parentTest.get().pass("Test passed");
	}

	/*
	 * if test fail without screenshort but we use with screenshot when teat is fail
	 * public synchronized void onTestFailure(ITestResult result) {
	 * System.out.println("Test Failed: "+ result.getMethod().getMethodName()+"  "+
	 * result.getThrowable()); parentTest.get().fail(result.getThrowable()); }
	 */

	// If Test is Fail we capture screen short
	public synchronized void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getMethod().getMethodName() + "  " + result.getThrowable());
		WebDriver driver = null;
		try {
			Field myField = result.getTestClass().getRealClass().getDeclaredField("driver");
			driver = (WebDriver) myField.get(result.getInstance());
		}
		catch (Exception e1) 
		{
		}
		
		System.out.println("Driver value is " + driver);
		//call utility package capturescreenshort64 method
		String src = Utility.captureScreenShort64(driver);
		
			try {
				parentTest.get().fail(result.getThrowable(),
				MediaEntityBuilder.createScreenCaptureFromBase64String(src).build());
			} catch (IOException e) {
				System.out.println("Image Capture is fail.");
				//e.printStackTrace();
			}
	}//end fail methods
	
	public void getScreenCaptureddata()
	{
//		WebDriver driver = null;
//		try {
//			Field myField = result.getTestClass().getRealClass().getDeclaredField("driver");
//			driver = (WebDriver) myField.get(result.getInstance());
//		}
//		catch (Exception e1) 
//		{
//		}
		
	}

	// if test skip
	public synchronized void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getMethod().getMethodName());
		parentTest.get().skip(result.getThrowable());
	}

	public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}
}