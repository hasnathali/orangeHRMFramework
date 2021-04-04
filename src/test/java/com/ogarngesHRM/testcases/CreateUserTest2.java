package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.AdminPage;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class CreateUserTest2 extends BaseClass {
	

	AdminPage admin;
	HomePage home;
	Dashboard dashboard;
	public WebDriver driver;
	
	@Test(dataProvider="TestData",dataProviderClass=TestDataProvider.class,priority=1)
	public void login_001(String user, String pass)
	{
		driver = getDriver();
		home = new HomePage(driver);
		home.enterUserName(user);
		home.enterpassword(pass);
		home.loginButton();
		
		admin = new AdminPage(driver);
		dashboard = new Dashboard(driver);
		dashboard.clickAdmin();
	}
	
	@Test(dataProvider="NewUserTestData",dataProviderClass=TestDataProvider.class,priority=2)
	public void createUser_001(String userRole, String employeeName, String userName, String password, String ConPassword)
	{
		//driver = getDriver()
	
		admin.clickAddUser();
		
		admin.enterUserRole(userRole);
		admin.enterEmployeeName(employeeName);
		admin.userName(userName);
		admin.userStatus();
		admin.userPassword(password);
		admin.userConPassword(ConPassword);
		admin.click();
		//admin.userverify(userName);
		admin.urlVerify();
		
	}
	
	@Test(priority=3)
	public void logout_002()
	{
		dashboard = new Dashboard(driver);
		dashboard.logOut();
	}
	


}
