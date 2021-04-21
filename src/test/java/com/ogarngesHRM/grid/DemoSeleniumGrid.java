package com.ogarngesHRM.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DemoSeleniumGrid {
	
	@Test
	public void testBrowserStack() throws InterruptedException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "88.0");
//		caps.setCapability("browserstack.local", "true");
//		caps.setCapability("browserstack.debug", "true");
//		caps.setCapability("browserstack.networkLogs", "true");
//		caps.setCapability("browserstack.selenium_version", "3.14.0");
		
		String AUTOMATE_USERNAME = "syed181";
		String AUTOMATE_ACCESS_KEY = "AMy3AgpKctyn3sepa9Qs";
		String HubURL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		  
		//String HubURL ="https://syed181:AMy3AgpKctyn3sepa9Qs@hub-cloud.browserstack.com/wb/hub";
		
		URL hurl;
		WebDriver driver=null;
		try {
			hurl = new URL(HubURL);
			driver = new RemoteWebDriver(hurl, caps);
		} catch (MalformedURLException e) {

		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[id='welcome']")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();
	}

}
