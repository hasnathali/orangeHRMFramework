package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class LoginTest extends BaseClass {
	

	HomePage home;
	public WebDriver driver;
	
	@Test(dataProvider="TestData",dataProviderClass=TestDataProvider.class)
	public void login_001(String user, String pass)
	{
		driver = getDriver();
		System.out.println("Login Test Case....");
		home = new HomePage(driver);
		home.enterUserName(user);
		//home.enterUserName("Admin");
		home.enterpassword(pass);
		home.loginButton();
	}
	

	@Test
	public void logout_002()
	{
		Dashboard dashboard = new Dashboard(driver);
		dashboard.logOut();
	}


}
