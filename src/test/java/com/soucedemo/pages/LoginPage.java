package com.soucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	
	@FindBy(id = "user-name") private WebElement usernameTextBox;
	@FindBy(id = "password") private WebElement passwordTextBox;
	@FindBy(id = "login-button") private WebElement loginButton;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLabLogo;
//	@FindBy(xpath="//*[@id='login_button_container']/div/form/div[3]/h3/text()") private WebElement errorMassage;
	
	
	
	public void setUsername(String username) 
	{
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
	} 
	
	public void setPassword(String password) 
	{
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	} 
	
	public void clickLoginButton() 
	{
		loginButton.click();
	}
	
	public boolean swagLabLogoDisplayed() 
	{
		return swagLabLogo.isDisplayed();
	}
	
	public boolean usernameTextBoxDisplayed() 
	{
		return usernameTextBox.isDisplayed();
	}
	
	public boolean passwordTextBoxDisplayed() 
	{
		return passwordTextBox.isDisplayed();
	}
	
	public boolean loginButtonisplayed() 
	{
		return loginButton.isDisplayed();
	}
	
	
	
	
}
