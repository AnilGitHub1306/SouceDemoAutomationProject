package com.soucedemo.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static ThreadLocal <WebDriver> threadDriver= new ThreadLocal<>();
	
	public static WebDriver getDriver()
	{
		return threadDriver.get();
	}
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browserName)
	{
		WebDriver localDriver; 
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		localDriver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			localDriver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			localDriver = new EdgeDriver();
		}
		else
		{
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
		
		threadDriver.set(localDriver);
		getDriver().manage().window().maximize();
		getDriver(). manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get("https://www.saucedemo.com/");
	}
	
	@AfterMethod
	public void tearDown() 
	{
		if(getDriver()!=null)
		{
			getDriver().quit();
			threadDriver.remove();
		}
		
	}
	

}
