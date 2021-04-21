package com.ogarngesHRM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import com.ogarngesHRM.utility.Utility;

public class AdminPage {
	
	WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By userRole = By.xpath("//*[text()='User Role']//following::select[1]");
	By employeeName= By.xpath("//input[@id= 'systemUser_employeeName_empName']");
	By userName= By.xpath("//*[@id='systemUser_userName']");
	By status= By.id("systemUser_status");
	By pass= By.xpath("(//input[@type= 'password'])[1]");
	By con_pass= By.xpath("(//input[@type= 'password'])[2]");
	By click= By.xpath("//input[@id='btnSave']");
	By clickAdd =By.xpath("//input[@id='btnAdd']");
	
	
	public void clickAddUser()
	{
		Utility.findElement(driver, clickAdd).click();
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "saveSystemUser"));
	}
	
	public void enterUserRole(String usrRoleData)
	{
		Utility.selectTextFromDropBox(driver, userRole, usrRoleData );
	}
	
	public void enterEmployeeName(String employeeData)
	{
		Utility.type(driver, employeeName, employeeData );
	}
	
	public void userName(String userNameData)
	{
		Utility.type(driver, userName, userNameData );
	}
	
	public void userStatus()
	{
		Utility.selectTextFromDropBox(driver, status, "Enabled" );
	}
	
	public void userPassword(String userPassData)
	{
		Utility.type(driver, pass, userPassData );
	}
	
	public void userConPassword(String userConPassData)
	{
		Utility.type(driver, con_pass, userConPassData );
	}
	
	public void click()
	{
		Utility.waitForClick(driver, click, 20 );
	}
	
	
	public void userverify(String UserName)
	{
		By createUser = By.xpath("//*[text()='\"+UserName+\"']");
		Assert.assertTrue(Utility.getText(driver, createUser).contains(UserName));
		System.out.println("User Create Successfully.");
		//Assert.assertTrue(Utility.waitForCurrentURL(driver, "viewSystemUsers"));
	}
	
	public boolean urlVerify()
	{
		Assert.assertTrue(Utility.waitForCurrentURL(driver, "viewSystemUsers"));
		return true;
	}
	
	


}//end class
