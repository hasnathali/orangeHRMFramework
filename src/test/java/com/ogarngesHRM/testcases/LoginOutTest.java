package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class LoginOutTest extends BaseClass {
	

	Dashboard dashboard;
	public WebDriver driver;
	
	@Test
	public void logout_002()
	{
		dashboard = new Dashboard(driver);
		dashboard.logOut();
	}


}
