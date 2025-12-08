package com.soucedemo.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class MyUtils {
	
	private static final Logger log = LogManager.getLogger(MyUtils.class);

    private static Properties prop;
    private static File f;
    private static FileInputStream ifs;
	
	public static String takeScreenshot(WebDriver driver, String screenshotName) 
	{
		try {
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String filePath = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+screenshotName+"_"+timestamp+".png";
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File TargetFile = new File(filePath);
		FileHandler.copy(sourceFile, TargetFile);
		log.info("Test failed hence, Screenshot taken");
		return filePath;
		} 
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	public static String ConfigReader(String key) 
	{
		try {
		prop =new Properties();
		String configPath = System.getProperty("user.dir")+File.separator+"src" + File.separator + "main" + File.separator +"resources" + File.separator + "config.properties";
		f =new File(configPath);
		ifs = new FileInputStream(f);
		prop.load(ifs);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
