package com.ebay.pages.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
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
		loginpage = new LoginPage();
	}
	
	
	//verifying user lands on the correct page once starts the application
	@Test(priority = 1)
	public void verifyLandingPage()
	{
		boolean landingpageTitle = landingpage.confirmingLandingPage();
		System.out.println("landing page title is :: " +landingpageTitle);
		Assert.assertTrue(landingpageTitle, "true");
	}
	
	
	@Test(priority = 2)
	public void clickSignIn()
	{
		loginpage = landingpage.clickSignInButton();
	}
	
}
