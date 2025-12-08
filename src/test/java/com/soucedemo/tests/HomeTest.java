package com.soucedemo.tests;

import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.soucedemo.base.Base;
import com.soucedemo.listeners.MyListener;
import com.soucedemo.pages.HomePage;
import com.soucedemo.pages.LoginPage;
@Listeners(MyListener.class)
public class HomeTest extends Base {
	
	LoginPage lp;
	HomePage hp;
	private static final Logger log = LogManager.getLogger(HomeTest.class);
	
	@Test(description = "TC014: Verify the title of the home page",
			priority=1,
			groups={"regression"})
	public void homePageTitle()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		
		hp = new HomePage(getDriver());
		String actualHomePageTitle = hp.homePageTitle();
		String expectedHomePageTitle = "Swag Labs";
		Assert.assertEquals(actualHomePageTitle,  expectedHomePageTitle);
		log.info("Actual home page title: "+actualHomePageTitle+" and "+"Expected home page title: "+expectedHomePageTitle+" is same");
		
	}
	
	@Test(description = "TC015: Verify the url of the home page",
			priority=2,
			groups={"regression"})
	public void homePageUrl()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		
		hp = new HomePage(getDriver());
		String actualHomePageUrl = hp.homePageUrl();
		System.out.println(actualHomePageUrl);
		String expectedHomePageUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualHomePageUrl,  expectedHomePageUrl);
		log.info("Actual home page url: "+actualHomePageUrl+" and "+"Expected home page url: "+expectedHomePageUrl+" is same");
	}

}
