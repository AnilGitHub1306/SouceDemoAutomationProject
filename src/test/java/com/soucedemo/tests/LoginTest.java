package com.soucedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.soucedemo.base.Base;
import com.soucedemo.listeners.MyListener;
import com.soucedemo.pages.LoginPage;

@Listeners(MyListener.class)
public class LoginTest extends Base {
	
	LoginPage lp;
	
	@Test(description = "TC001: Verify user is able to login with valid username and valid password",
			groups={"smoke", "sanity", "regression", "highPriority"})
	public void loginValidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC002: Verify user is able to login with valid username and invalid password",
			groups={"regression"})
	public void loginValidUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("standard_user");
		lp.setPassword("123");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC003: Verify user is able to login with invalid username and valid password",
			groups={"regression"})
	public void loginInvalidUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("abc");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC004: Verify user is able to login with invalid username and invalid password",
			groups={"regression"})
	public void loginInvalidUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("abc");
		lp.setPassword("123");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC005: Verify user is able to login with empty username and valid password",
			groups={"regression"})
	public void loginEmptyUsernameValidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("");
		lp.setPassword("secret_sauce");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC006: Verify user is able to login with empty username and invalid password",
			groups={"regression"})
	public void loginEmptyUsernameInvalidPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("");
		lp.setPassword("123");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC007: Verify user is able to login with empty username and empty password",
			groups={"regression"})
	public void loginEmptyUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("");
		lp.setPassword("");
		lp.clickLoginButton();
		
		
	}
	
	@Test(description = "TC008: Verify user is able to login with valid username and empty password",
			 groups={"sanity", "regression"})
	public void loginValidUsernameEmptyPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("standard_user");
		lp.setPassword("");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC009: Verify user is able to login with invalid username and empty password",
			 groups={"sanity", "regression"})
	public void loginInvalidUsernameEptyPassword()
	{
		lp = new LoginPage(getDriver());
		lp.setUsername("abc");
		lp.setPassword("");
		lp.clickLoginButton();
	}
	
	@Test(description = "TC010: Verify swaglab logo present on login page",
			 groups={"sanity", "regression"})
	public void loginPageLogo()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.swagLabLogoDisplayed());
	}
	
	@Test(description = "TC011: Verify username textbox is present on login page",
			 groups={"sanity", "regression"})
	public void usrnameTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.usernameTextBoxDisplayed());
	}
	
	@Test(description = "TC012: Verify password textbox is present on login page",
			 groups={"sanity", "regression"})
	public void passwordTextBoxOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.passwordTextBoxDisplayed());
	}
	
	@Test(description = "TC013: Verify ogin button is present on login page",
			 groups={"sanity", "regression"})
	public void loginButtonOnLoginPage()
	{
		lp = new LoginPage(getDriver());
		Assert.assertTrue(lp.loginButtonisplayed());
	}
	
}
