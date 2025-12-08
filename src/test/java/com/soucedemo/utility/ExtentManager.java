package com.soucedemo.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	public static ExtentReports getExtent()
	{
		if (extent == null) { 
		String timestamp =new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String extentReportPath = System.getProperty("user.dir")+File.separator+"reports"+File.separator+"ExtentReport"+timestamp+".html";
		File f= new File(extentReportPath);
		spark = new ExtentSparkReporter(f);
		extent =new ExtentReports();
		extent.attachReporter(spark);
		
		
		extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Tester", "Anil");
        
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Test Report");
        spark.config().setReportName("Execution Report");
		}
        return extent;
	}

}
