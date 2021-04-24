package com.ogarngesHRM.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ogarngesHRM.dataprovider.ConfigFileReader;
import com.ogarngesHRM.utility.BrowserFactory;

public class BaseClass {

	public WebDriver driver;// public because need access from testcase

	public WebDriver getDriver() {
		return driver;
	}

	/*
	 * @Parameters({"Browsr","StagingURL"})
	 * 
	 * @BeforeClass public void startBrowser(String Browser, String url) {
	 * System.out.println("**********Browser is Starting***********");
	 * BrowserFactory browserfactory = new BrowserFactory(); driver =
	 * browserfactory.stratBrowser(Browser,url);
	 * System.out.println("**********Browser is Running***********"); }
	 */
	// String osName,String osVersion,String browsrName,String browserVersion,
	// String applicationURL
	@Parameters({"runoncloud", "OsName", "OsVersion", "Browsr", "BrowsrVersion", "StagingURL" })
	@BeforeClass
	public void startBrowser(boolean runoncloud, @Optional("Windows") String OsName, @Optional("10") String OsVersion,
			@Optional("chrome") String Browser, @Optional("88.0") String BrowsrVersion, String url) 
	{
		if(runoncloud==true)
		{
			startBrowseronnGrid(OsName, OsVersion, Browser, BrowsrVersion, url);
			
		}
		else
		{
			startBrowseronLocal(Browser, url);
		}
	
	}

	public void startBrowseronnGrid(String OsName, String OsVersion,
			String Browser, String BrowsrVersion, String url) 
	{
		System.out.println("*****Start Browser on BrowserStack with bellow details:*****");

		System.out.println("OS Name " + OsName);
		System.out.println("OS Version " + OsVersion);
		System.out.println("Browser Name " + Browser);
		System.out.println("Browser Version " + BrowsrVersion);
		System.out.println("Application url " + url);

		BrowserFactory browserfactory = new BrowserFactory();
		driver = browserfactory.stratBrowserOnGrid(OsName, OsVersion, Browser, BrowsrVersion, url);
		System.out.println("**********Browser is to going Start and run the test ***********");
	}

	public void startBrowseronLocal(String Browser, String url) 
	{
		System.out.println("**********Browser is Starting***********");
		BrowserFactory browserfactory = new BrowserFactory();
		driver = browserfactory.stratBrowser(Browser, url);
		System.out.println("**********Browser is Running***********");
	}

	/*
	 * @BeforeClass public void startBrowser() {
	 * System.out.println("**********Browser is Starting***********");
	 * BrowserFactory browserfactory = new BrowserFactory(); //Get Browser name and
	 * URL From Configure file ConfigFileReader config = new ConfigFileReader();
	 * String Browsr =config.getProperty("Browser"); String URL =
	 * config.getProperty("StagingURL"); driver =
	 * browserfactory.stratBrowser(Browsr,URL); // OR //driver =
	 * browserfactory.stratBrowser(config.getProperty("Browser"),
	 * config.getProperty("StagingURL")); //driver =
	 * browserfactory.stratBrowser("chrome",
	 * "https://opensource-demo.orangehrmlive.com/");
	 * System.out.println("**********Browser is Running***********"); }
	 */

	@AfterClass
	public void closeBroswer() {
		driver.close();
		driver.quit();
		System.out.println("**********Browser is Closing*************");
	}

}// end class
