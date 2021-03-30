package com.ogarngesHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.ogarngesHRM.utility.Utility;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		this.driver= driver;
	}
	
	By username = By.id("txtUsername");
	By pass = By.id("txtPassword");
	By loginButton = By.id("btnLogin");
	
	public void enterUserName(String userName)
	{
		Utility.type(driver, username, userName);
		//driver.findElement(username).sendKeys(userName);
	}
	
	public void enterpassword(String password)
	{
		Utility.type(driver, pass, password);
		//driver.findElement(pass).sendKeys(password);
	}
	
	public void loginButton()
	{
		Utility.click(driver, loginButton);
		System.out.println("Login Successfully.");
		//driver.findElement(loginButton).click();
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "dashboard"));
		//Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
	}

}
