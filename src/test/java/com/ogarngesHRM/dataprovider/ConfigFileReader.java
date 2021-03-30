package com.ogarngesHRM.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	FileInputStream fls;
	Properties pro;
	
	public ConfigFileReader()
	{	
		File src = new File(System.getProperty("user.dir")+"/Config/Config.properties");
		try {
			fls = new FileInputStream(src);
		} catch (FileNotFoundException e) 
		{
			System.out.println("Could not read the file."+ e.getMessage());
		}
		
		pro = new Properties();
		try {
			pro.load(fls);
		} catch (IOException e)
		{
			System.out.println("Could not read the file."+ e.getMessage());
		}
	}//end method
	
	public String getProperty(String key)
	{
		String Dat = pro.getProperty(key);
		return Dat;
		//or
		//return pro.getProperty(key);
	}

}//end class
