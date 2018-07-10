package com.ebay.pages;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class LoginPage extends BaseSetup{

	//Login Page object repository
	
	@FindBy(id = "com.ebay.mobile:id/edit_text_username")
	WebElement Username;
	
	@FindBy(id = "com.ebay.mobile:id/edit_text_password")
	WebElement Password;
	
	@FindBy(id = "com.ebay.mobile:id/button_sign_in")
	WebElement SubmitButton;
	
		
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	

	public boolean verifyLoginPage()
	{
		boolean value = SubmitButton.isDisplayed();
		return value;
	}
	
	
	public AccountLinkPage LoginIntoAccount(String un, String pwd) throws IOException
	{
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		SubmitButton.click();
		return new AccountLinkPage();
	}
}
