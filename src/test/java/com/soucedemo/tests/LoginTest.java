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
import com.soucedemo.utility.MyUtils;

@Listeners(MyListener.class)
public class LoginTest extends Base {
	
	private static final Logger log = LogManager.getLogger(LoginTest.class);
	LoginPage lp;
	HomePage hp;
	
	@Test(description = "TC001: Verify user is able to login with valid username and valid password",
			priority=1,
			groups={"smoke", "sanity", "regression", "highPriority"})
	public void loginValidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and valid password");
		
		lp.setUsername(MyUtils.ConfigReader("valid_username"));
		lp.setPassword(MyUtils.ConfigReader("valid_password"));
		lp.clickLoginButton();
		hp =new HomePage(Base.getDriver());
		String expectedHomePageurl = hp.homePageUrl();
		String actualUrl = MyUtils.ConfigReader("homepage_url");
		
		Assert.assertEquals(expectedHomePageurl,actualUrl);
		log.info("Actual and axpected url are same");
	}
	
	@Test(description = "TC002: Verify user is able to login with valid username and invalid password",
			priority=2,
			groups={"regression"})
	public void loginValidUsernameInvalidPassword()
	{
		
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and invalid password");
		lp.setUsername(MyUtils.ConfigReader("valid_username"));
		lp.setPassword(MyUtils.ConfigReader("invalid1_password"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
		
	
	}
	
	@Test(description = "TC003: Verify user is able to login with invalid username and valid password",
			priority=3,
			groups={"regression"})
	public void loginInvalidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and valid password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username1"));
		lp.setPassword(MyUtils.ConfigReader("valid_password"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC004: Verify user is able to login with invalid username and invalid password",
			priority=4,
			groups={"regression"})
	public void loginInvalidUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and invalid password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username1"));
		lp.setPassword(MyUtils.ConfigReader("invalid_username1"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC005: Verify user is able to login with empty username and valid password",
			priority=5,
			groups={"regression"})
	public void loginEmptyUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and valid password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username2"));
		lp.setPassword(MyUtils.ConfigReader("valid_password"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC006: Verify user is able to login with empty username and invalid password",
			priority=6,
			groups={"regression"})
	public void loginEmptyUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and invalid password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username2"));
		lp.setPassword(MyUtils.ConfigReader("valid_password1"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC007: Verify user is able to login with empty username and empty password",
			priority=7,
			groups={"regression"})
	public void loginEmptyUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering empty username and empty password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username2"));
		lp.setPassword(MyUtils.ConfigReader("invalid_username2"));
		lp.clickLoginButton();
		boolean status = lp.errorMassageIsDisplayed();
		Assert.assertTrue(status);
		log.info("Error massage is display");
		
		
	}
	
	@Test(description = "TC008: Verify user is able to login with valid username and empty password",
			priority=8,
			groups={"sanity", "regression"})
	public void loginValidUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering valid username and empty password");
		lp.setUsername(MyUtils.ConfigReader("valid_username"));
		lp.setPassword(MyUtils.ConfigReader("invalid_password2"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC009: Verify user is able to login with invalid username and empty password",
			priority=9,
			groups={"sanity", "regression"})
	public void loginInvalidUsernameEptyPassword()
	{
		lp = new LoginPage(getDriver());
		log.info("Entering invalid username and empty password");
		lp.setUsername(MyUtils.ConfigReader("invalid_username1"));
		lp.setPassword(MyUtils.ConfigReader("invalid_password2"));
		lp.clickLoginButton();
		Assert.assertTrue(lp.errorMassageIsDisplayed());
		log.info("Error massage is display");
	}
	
	@Test(description = "TC010: Verify swaglab logo present on login page",
			priority=10,
			groups={"sanity", "regression"})
	public void loginPageLogo()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.swagLabLogoDisplayed());
		log.info("Swag lab logo is present on the login page");
		
	}
	
	@Test(description = "TC011: Verify username textbox is present on login page",
			priority=11,
			groups={"sanity", "regression"})
	public void usrnameTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.usernameTextBoxDisplayed());
		log.info("Username text box is present on the login page");
	}
	
	@Test(description = "TC012: Verify password textbox is present on login page",
			priority=12,
			groups={"sanity", "regression"})
	public void passwordTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.passwordTextBoxDisplayed());
		log.info("Password text box is present on the login page");
	}
	
	@Test(description = "TC013: Verify login button is present on login page",
			priority=13,
			groups={"sanity", "regression"})
	public void loginButtonOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.loginButtonIsDisplayed());
		log.info("Login button is present on the login page");
	}
	
}
