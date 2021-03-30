package com.ogarngesHRM.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public Object[][] getExcelData(String sheetName)
	{
		System.out.println("Sheet Name: "+ sheetName);
		XSSFWorkbook wb=null;
		try {
			wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/Data.xlsx")));
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		int RowCount= wb.getSheet(sheetName).getPhysicalNumberOfRows();
		int ColumnCount = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
		
		//We return object thats why we create 2D array object type
		Object[][] arr = new Object[RowCount][ColumnCount];
		
		for(int i=0;i<RowCount;i++)
		{
			for(int j=0;j<ColumnCount;j++)
			{
				arr[i][j]= wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
			}
		}
		System.out.println("******Test Data Generated*********");
		try {
			wb.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		return arr;
		
		
	}//end methods

}//end class
