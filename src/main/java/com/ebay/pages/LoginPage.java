package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class LoginPage extends BaseSetup{

	//Login Page object repository
	
	@FindBy(id="com.ebay.mobile:id/edit_text_password")
	WebElement passWord;
	
	@FindBy(id="com.ebay.mobile:id/edit_text_username")
	WebElement userName;
	
	@FindBy(id="com.ebay.mobile:id/button_sign_in")
	WebElement signInButton;
	
		
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyLoginPage()
	{
		
		boolean value = signInButton.isDisplayed();
		System.out.println("sign in button is displayed or not :: " +value);
		return value;
	}
		
	
	public AccountLinkPage LoginIntoAccount(String un, String pwd) throws IOException, InterruptedException
	{
			userName.sendKeys(un);
			passWord.sendKeys(pwd);
			signInButton.click();		
			return new AccountLinkPage();
	}
}