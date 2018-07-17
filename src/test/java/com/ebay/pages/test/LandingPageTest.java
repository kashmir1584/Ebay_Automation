package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;

public class LandingPageTest extends BaseSetup{

	LandingPage landingpage;
	LoginPage loginpage;
	
	
	public LandingPageTest() throws IOException
	{
		//calling setup class constructor 
		super();
	}
	
	
	@BeforeMethod
	public void initialSetup() throws IOException
	{
		//creating objects of landingpage and loginpage
		landingpage = new LandingPage();
	}
	
	
	//verifying user lands on the correct page once starts the application
	@Test(priority = 1)
	public void verifyLandingPage()
	{
		boolean result = landingpage.confirmingLandingPage();
		System.out.println("landing page title is :: " +result);
		Assert.assertTrue(result, "true");
	}
	
	
	@Test(priority = 2)
	public void clickSignIn() throws IOException
	{
		loginpage = landingpage.clickSignInButton();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
