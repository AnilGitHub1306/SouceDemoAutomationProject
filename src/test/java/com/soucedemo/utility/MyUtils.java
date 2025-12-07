package com.soucedemo.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class MyUtils {
	
	public static String takeScreenshot(WebDriver driver, String screenshotName) 
	{
		try {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+screenshotName+"_"+timestamp+".png";
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File(filePath);
		FileHandler.copy(sourceFile, TargetFile);
		return filePath;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
