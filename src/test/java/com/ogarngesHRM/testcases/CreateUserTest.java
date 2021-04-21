package com.ogarngesHRM.testcases;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.AdminPage;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class CreateUserTest extends BaseClass {
	/*
	 * Create user using DataBase
	 */

	
	HomePage home;
	AdminPage admin;
	Dashboard dashboard;
	public WebDriver driver;
	ArrayList<String>myUsers=new ArrayList<String>();
	
	@Test(dataProvider="MySqlTestData",dataProviderClass=TestDataProvider.class)
	public void createUser_001(String adminId, String adminPass, String userRole, String employeeName, String userName, String password)
	{
		driver = getDriver();
		home = new HomePage(driver);
		admin = new AdminPage(driver);
		dashboard = new Dashboard(driver);
		
		home.enterUserName(adminId);
		home.enterpassword(adminPass);
		home.loginButton();
		//CLick Admin menu
		dashboard.clickAdmin();
		
		//Click Add user
		admin.clickAddUser();
		//Add user details
		admin.enterUserRole(userRole);
		admin.enterEmployeeName(employeeName);
		admin.userName(userName);
		admin.userStatus();
		admin.userPassword(password);
		admin.userConPassword(password);
		admin.click();
		//admin.userverify(userName);
		boolean status=admin.urlVerify();
		if(status)
		{
			myUsers.add("Success");
		}
		else
		{
			myUsers.add("Failure");
		}
		dashboard.logOut();
		
	}
	


}
