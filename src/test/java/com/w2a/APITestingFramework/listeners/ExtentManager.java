package com.w2a.APITestingFramework.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {

	private static ExtentReports extent;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
	       
	        
	        sparkReporter.config().setTheme(Theme.STANDARD);
	        sparkReporter.config().setDocumentTitle(fileName);
	        sparkReporter.config().setEncoding("utf-8");
	        sparkReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(sparkReporter);
	        extent.setSystemInfo("Automation Tester", "Partha");
	        extent.setSystemInfo("Organization", "Coming Soon...");
	        extent.setSystemInfo("Build no", "CS-1234");
	        
	        
	        return extent;
	    }

	}
