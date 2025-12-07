package com.soucedemo.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.soucedemo.base.Base;
import com.soucedemo.listeners.MyListener;
import com.soucedemo.pages.HomePage;
import com.soucedemo.pages.LoginPage;

@Listeners(MyListener.class)
public class LoginTest extends Base {
	
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	LoginPage lp;
	HomePage hp;
	
	@Test(description = "TC001: Verify user is able to login with valid username and valid password",
			groups={"smoke", "sanity", "regression", "highPriority"})
	public void loginValidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and valid password");
		
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		hp =new HomePage(Base.getDriver());
		String expectedHomePageurl = hp.homePageUrl();
		String actualUrl = "";
		
		Assert.assertEquals(expectedHomePageurl,actualUrl);
		log.info("Actual and axpected url are same");
	}
	
	@Test(description = "TC002: Verify user is able to login with valid username and invalid password",
			groups={"regression"})
	public void loginValidUsernameInvalidPassword()
	{
		
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and invalid password");
		lp.setUsername("standard_user");
		lp.setPassword("123");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
		
	
	}
	
	@Test(description = "TC003: Verify user is able to login with invalid username and valid password",
			groups={"regression"})
	public void loginInvalidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and valid password");
		lp.setUsername("abc");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC004: Verify user is able to login with invalid username and invalid password",
			groups={"regression"})
	public void loginInvalidUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and invalid password");
		lp.setUsername("abc");
		lp.setPassword("123");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC005: Verify user is able to login with empty username and valid password",
			groups={"regression"})
	public void loginEmptyUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and valid password");
		lp.setUsername("");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC006: Verify user is able to login with empty username and invalid password",
			groups={"regression"})
	public void loginEmptyUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and invalid password");
		lp.setUsername("");
		lp.setPassword("123");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC007: Verify user is able to login with empty username and empty password",
			groups={"regression"})
	public void loginEmptyUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and empty password");
		lp.setUsername("");
		lp.setPassword("");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
		
		
	}
	
	@Test(description = "TC008: Verify user is able to login with valid username and empty password",
			 groups={"sanity", "regression"})
	public void loginValidUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and empty password");
		lp.setUsername("standard_user");
		lp.setPassword("");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC009: Verify user is able to login with invalid username and empty password",
			 groups={"sanity", "regression"})
	public void loginInvalidUsernameEptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and empty password");
		lp.setUsername("abc");
		lp.setPassword("");
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC010: Verify swaglab logo present on login page",
			 groups={"sanity", "regression"})
	public void loginPageLogo()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.swagLabLogoDisplayed());
		log.info("Swag lab logo is present on the login page");
		
	}
	
	@Test(description = "TC011: Verify username textbox is present on login page",
			 groups={"sanity", "regression"})
	public void usrnameTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.usernameTextBoxDisplayed());
		log.info("Username text box is present on the login page");
	}
	
	@Test(description = "TC012: Verify password textbox is present on login page",
			 groups={"sanity", "regression"})
	public void passwordTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.passwordTextBoxDisplayed());
		log.info("Password text box is present on the login page");
	}
	
	@Test(description = "TC013: Verify ogin button is present on login page",
			 groups={"sanity", "regression"})
	public void loginButtonOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.loginButtonIsDisplayed());
		log.info("Login button is present on the login page");
	}
	
}
