package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class LandingPage extends BaseSetup{

	//Landing Page Object repository
	
	@FindBy(id = "button_register")
	WebElement RegisterButton;
	
	@FindBy(id="button_sign_in")
	WebElement signInButton;	
	
		
	LoginPage loginpage;
	
	
	public LandingPage() throws IOException
	{
		//initializing the web elements using page factory
		PageFactory.initElements(driver, this);
	}
	
	
	//verifying if Sign In button is displayed on landing page or not
	public boolean confirmingLandingPage()
	{
		boolean value = signInButton.isDisplayed();
		return value;
	}
	
	
	public LoginPage clickSignInButton()
	{
		signInButton.click();
		return loginpage;
	}
	
}
