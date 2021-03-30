package com.ogarngesHRM.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ogarngesHRM.utility.Utility;

public class Dashboard {
	
	WebDriver driver;
	
	By adminPage = By.xpath("//a[@id='menu_admin_viewAdminModule']/b");
	
	
	public Dashboard(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickAdmin()
	{
		Utility.findElement(driver, adminPage).click();
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "viewSystemUsers"));
	}
	
	
	By welcodetext = By.xpath("//a[contains(text(),'Welcome')]");
	By lgout= By.xpath("//a[text()='Logout']");
	
	public void logOut()
	{
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(welcodetext).click();
		//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(lgout))).click();
		driver.findElement(lgout).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("login"));
	}

}//end class
