package com.ogarngesHRM.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	 private static ExtentReports extent;
	    
	    public static ExtentReports getInstance()
	    {
	    	if (extent == null)
	    	{//System.getProperty("user.dir")+
	    		createInstance(System.getProperty("user.dir")+"/Reports/Report_"+System.currentTimeMillis()+".html");
	    	}
	    	
	        return extent;
	    }
	    
	    public static ExtentReports createInstance(String fileName)
	    {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        
	        return extent;
	    }

}
