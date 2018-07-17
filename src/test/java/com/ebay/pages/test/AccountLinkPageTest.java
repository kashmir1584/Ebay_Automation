package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;

public class AccountLinkPageTest extends BaseSetup{
	
	LandingPage landingpage;
	LoginPage loginpage;
	AccountLinkPage accountlinkpage;
	HomePage homepage;
	
	public AccountLinkPageTest() throws IOException
	{
		super();
	}

	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		landingpage = new LandingPage();
		loginpage = landingpage.clickSignInButton();
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority =1)
	public void verifyAccountLinkPageTest()
	{
		boolean result = accountlinkpage.verifyAccountLinkPage();
		Assert.assertTrue(result, "true");
	}
	
	
	@Test(priority = 2)
	public void doNotLinkAccountTest() throws IOException
	{
		homepage = accountlinkpage.doNotLinkAccount();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}