package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.AdminPage;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class CreateUserTest extends BaseClass {
	

	AdminPage admin;
	Dashboard dashboard;
	public WebDriver driver;
	
	@Test(dataProvider="NewUserTestData",dataProviderClass=TestDataProvider.class)
	public void createUser_001(String userRole, String employeeName, String userName, String status, String password, String ConPassword)
	{
		driver = getDriver();
		
		admin = new AdminPage(driver);
		dashboard = new Dashboard(driver);
		
		dashboard.clickAdmin();
		admin.clickAddUser();
		
		admin.enterUserRole(userRole);
		admin.enterEmployeeName(employeeName);
		admin.userName(userName);
		admin.userStatus();
		admin.userPassword(password);
		admin.userConPassword(ConPassword);
		admin.click();
		admin.userverify(userName);
		
	}
	


}
