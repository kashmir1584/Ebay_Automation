package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;

public class LoginPageTest extends BaseSetup {

	LoginPage loginpage;
	LandingPage landingpage;
	AccountLinkPage accountlinkpage;
	HomePage homepage;
	
		
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeClass
	public void InitialSetup() throws IOException
	{
		desiredCapabilitiesSetup();
		landingpage = new LandingPage();
		loginpage = landingpage.clickSignInButton();
	}
	
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		String uname = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		System.out.println("username -- " +uname  + "    password is --" +pwd);
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
}