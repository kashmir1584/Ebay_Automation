package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class AccountLinkPage extends BaseSetup {

	@FindBy(id = "com.ebay.mobile:id/button_google_deny")
	WebElement noThanks;
	
	
	public AccountLinkPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyAccountLinkPage()
	{
		boolean result = noThanks.isDisplayed();
		return result;
	}
	
	
	public HomePage doNotLinkAccount() throws IOException
	{
		noThanks.click();
		return new HomePage();
	}
}