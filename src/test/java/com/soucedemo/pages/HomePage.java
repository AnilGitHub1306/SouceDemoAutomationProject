package com.soucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		log.info("HomePage initialized successfully");
	}
	
	public String homePageTitle()
	{
		String homePageTitle = driver.getTitle();
		log.info("Home page titel is: "+ homePageTitle);
		return homePageTitle;
	}
	
	public String homePageUrl() 
	{
		String homePageUrl = driver.getCurrentUrl();
		log.info("Home page ur is: "+ homePageUrl);
		return homePageUrl;
	}
	


}
