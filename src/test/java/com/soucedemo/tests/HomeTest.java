package com.soucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.soucedemo.base.Base;
import com.soucedemo.pages.HomePage;
import com.soucedemo.pages.LoginPage;

public class HomeTest extends Base {
	
	LoginPage lp;
	HomePage hp;
	
	@Test(description = "TC014: Verify the title of the home page",
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
	}
	
	@Test(description = "TC015: Verify the url of the home page",
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
	}

}
