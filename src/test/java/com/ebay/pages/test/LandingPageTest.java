package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;

public class LandingPageTest extends BaseSetup{

	LandingPage landingpage;
	LoginPage loginpage;
	
	
	public LandingPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeClass
	public void initialSetup() throws IOException
	{
		desiredCapabilitiesSetup();
		landingpage = new LandingPage();
	}
	
	
	@Test()
	public void clickSignIn() throws IOException
	{
		loginpage = landingpage.clickSignInButton();
	}
}