package com.ogarngesHRM.base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ogarngesHRM.dataprovider.ConfigFileReader;
import com.ogarngesHRM.utility.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;// public because need access from testcase
	
	
	public WebDriver getDriver()
	{
		return driver;
	}
	//*
	@Parameters({"Browsr","StagingURL"})
	@BeforeClass
	public void startBrowser(String Browser, String url)
	{
		System.out.println("**********Browser is Starting***********");
		BrowserFactory browserfactory = new BrowserFactory();
		driver = browserfactory.stratBrowser(Browser,url); 
		System.out.println("**********Browser is Running***********");
	}

	/*
	@BeforeClass
	public void startBrowser()
	{
		System.out.println("**********Browser is Starting***********");
		BrowserFactory browserfactory = new BrowserFactory();
		//Get Browser name and URL From Configure file 
		ConfigFileReader config = new ConfigFileReader();
		String Browsr =config.getProperty("Browser");
		String URL = config.getProperty("StagingURL");
		driver = browserfactory.stratBrowser(Browsr,URL); 
		// OR
		//driver = browserfactory.stratBrowser(config.getProperty("Browser"), config.getProperty("StagingURL"));
		//driver = browserfactory.stratBrowser("chrome", "https://opensource-demo.orangehrmlive.com/");
		System.out.println("**********Browser is Running***********");
	}
	*/
	
	@AfterClass
	public void closeBroswer()
	{
		driver.close();
		System.out.println("**********Browser is Closing*************");
	}
	

}//end class
