package com.ogarngesHRM.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ogarngesHRM.dataprovider.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public WebDriver stratBrowserOnGrid(String osName,String osVersion,String browsrName,String browserVersion, String applicationURL)
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", osName);
		caps.setCapability("os_version", osVersion);
		caps.setCapability("browser", browsrName);
		caps.setCapability("browser_version", browserVersion);
		
		ConfigFileReader confile = new ConfigFileReader();
		String AUTOMATE_USERNAME = confile.getProperty("GridUserName");
		String AUTOMATE_ACCESS_KEY = confile.getProperty("GridAccessKey");
		String GHubURL = confile.getProperty("HubURL");
		
		String HubURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + GHubURL;

		//String HubURL ="https://syed181:AMy3AgpKctyn3sepa9Qs@hub-cloud.browserstack.com/wb/hub";
		
		URL hurl = null;
		WebDriver driver=null;
	
		try {
			hurl = new URL(HubURL);
			driver = new RemoteWebDriver(hurl, caps);
			driver.get(applicationURL);
		} 
		catch (MalformedURLException e) {
			System.out.println("URL Mismatch " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Could not connect with hub: "+ e.getMessage());
		}
		
		return driver;
		
	}
	
	public WebDriver stratBrowser(String bName, String url)
	{
		WebDriver driver = null;
		
		if(bName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(bName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else if(bName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		else
		{
			System.out.println("Plese choose correct browser .");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		
	}

}//end class
