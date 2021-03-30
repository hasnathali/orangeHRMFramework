package com.ogarngesHRM.testcases;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.ogarngesHRM.base.BaseClass;
import com.ogarngesHRM.dataprovider.ExcelReader;
import com.ogarngesHRM.dataprovider.TestDataProvider;
import com.ogarngesHRM.pages.Dashboard;
import com.ogarngesHRM.pages.HomePage;

public class DemoTestData extends BaseClass {
	
	public static void main(String[] args) {
		
		Object[][] arr= new Object[4][5];
		
		ExcelReader EX = new ExcelReader();
		
		arr = EX.getExcelData("userinfo");
		
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.println(arr[i][j]);
			}
		}
		
		
		
	}


}
