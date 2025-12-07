package com.soucedemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this );
		log.info("LoginPage initialized successfully");
	}
	
	@FindBy(id = "user-name") private WebElement usernameTextBox;
	@FindBy(id = "password") private WebElement passwordTextBox;
	@FindBy(id = "login-button") private WebElement loginButton;
	@FindBy(xpath="//div[text()='Swag Labs']") private WebElement swagLabLogo;
	@FindBy(xpath="//*[@id='login_button_container']/div/form/div[3]/h3/text()") private WebElement errorMassage;
	
	
	
	public void setUsername(String username) 
	{
		log.info("Entering username "+username);
		usernameTextBox.clear();
		usernameTextBox.sendKeys(username);
	} 
	
	public void setPassword(String password) 
	{
		log.info("Entering password "+password);
		passwordTextBox.clear();
		passwordTextBox.sendKeys(password);
	} 
	
	public void clickLoginButton() 
	{
		log.info("Clicking Login button");
		loginButton.click();
	}
	
	public boolean swagLabLogoDisplayed() 
	{
		boolean result = swagLabLogo.isDisplayed();
		log.info("SwagLab Logo displayed: " + result);
		return result;
	}
	
	
	public boolean usernameTextBoxDisplayed() 
	{
		boolean status = usernameTextBox.isDisplayed();
		log.info("Username textbox displayed: "+status);
		return status;
	}
	
	public boolean passwordTextBoxDisplayed() 
	{
		boolean status =passwordTextBox.isDisplayed();
		log.info("Passwor textbox displayed: "+status);
		return status;
	}
	
	public boolean loginButtonIsDisplayed() 
	{
		boolean status =loginButton.isDisplayed();
		log.info("Login button displayed: "+status);
		return status;
	}
	
	public boolean errorMassageIsDisplayed() 
	{
		boolean status =errorMassage.isDisplayed();
		log.info("Error massage displayed: "+status);
		return status;
	}
	
	
	
}
