package com.ogarngesHRM.dataprovider;
import java.sql.SQLException;

import org.testng.annotations.DataProvider;


public class TestDataProvider {
	
	
	@DataProvider(name="TestData")
	public Object[][] getData()
	{
		ExcelReader excelreader = new ExcelReader();
		return excelreader.getExcelData("logininfo");
		
		//OR IF getExcelData is static we can use
		//return ExcelReader.getExcelData("userinfo");
	}
	
	@DataProvider(name="TestData2")
	public Object[][] getData2()
	{
		ExcelReader excelreader = new ExcelReader();
		return excelreader.getExcelData("logininfo2");
	}
	
	
	@DataProvider(name="NewUserTestData")
	public Object[][] getNewUserData()
	{
		ExcelReader excelreader = new ExcelReader();
		return excelreader.getExcelData("userinfo");

	}
	
	@DataProvider(name="MySqlTestData")
	public Object[][] getMySqlData() throws ClassNotFoundException, SQLException
	{
		DataBaseReader sqlreader = new DataBaseReader();
		return sqlreader.getMySqlData();
	}
	
	/*
	@DataProvider(name="MySqlTestData")
	public String[][] getMySqlData() throws ClassNotFoundException, SQLException
	{
		DataBaseReader sqlreader = new DataBaseReader();
		return sqlreader.getMySqlData();
	}
	 */
	
	
	
	
	
}//end class
