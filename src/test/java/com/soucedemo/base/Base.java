package com.soucedemo.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.soucedemo.utility.MyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	private static final Logger log = LogManager.getLogger(Base.class);
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
		log.info("===== Chrome browser is setup =====");
		
		localDriver = new ChromeDriver();
		log.info("Chrome browser is open");
		
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			log.info("===== Firefox browser is setup =====");
			
			localDriver = new FirefoxDriver();
			log.info("Firefox browser is open");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			log.info("===== Edge browser is setup =====");
			
			localDriver = new EdgeDriver();
			log.info("Edge browser is open");
		}
		else
		{
			log.info("Provide the correct browser name");
			throw new IllegalArgumentException("Invalid browser name: " + browserName);
		}
		
		threadDriver.set(localDriver);
		
		getDriver().manage().window().maximize();
		log.info(browserName +" browser is maximise");
		
		getDriver(). manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(MyUtils.ConfigReader("implicitwait"))));
		log.info("Implicit wait is setup");
		
		getDriver().get(MyUtils.ConfigReader("url"));
		log.info("Url is open");
	}
	

	@AfterMethod()
	public void tearDown() 
	{
		if(getDriver()!=null)
		{
			getDriver().quit();
			log.info("===== browser is close =====");
			
			threadDriver.remove();
		}
		
	}
	

}
