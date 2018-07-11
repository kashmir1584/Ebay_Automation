package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.LoginPage;

public class HomePageTest extends BaseSetup{

	AccountLinkPage accountlinkpage;
	LoginPage loginpage;
	LoginPageTest loginpagetest;
	HomePage homepage;
	
	
	public HomePageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		loginpage = new LoginPage();
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
		homepage = accountlinkpage.doNotLinkAccount();
	}
	
		
	@Test(priority = 1)
	public void verifyHomePage()
	{
		boolean value = homepage.confirmHomePage();
		Assert.assertEquals(value, "true");
	}
	
	
	@Test(priority = 2)
	public void searchForAnItem() throws IOException
	{
		homepage.searchAnItem(prop.getProperty("searchItem"));
	}
}