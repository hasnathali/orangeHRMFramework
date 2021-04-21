package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class LoginTest3 extends BaseClass {
	
	HomePage home;
	public WebDriver driver;
	
	
	@Test(dataProvider="MySqlTestData",dataProviderClass=TestDataProvider.class)
	public void login_001(String user, String pass)
	{
		driver=getDriver();
		home = new HomePage(driver);
		//logger= report.createTest("Login with admin."); // This report & logger variable is object of ExtentReports, It's From Base class
		home.enterUserName(user);
		//home.enterUserName("Admin");
		home.enterpassword(pass);
		home.loginButton();
		
		Dashboard dashboard = new Dashboard(driver);
		//logger= report.createTest("Logout"); // This report & logger variable is object of ExtentReports, It's From Base class
		dashboard.logOut();
	}

}
