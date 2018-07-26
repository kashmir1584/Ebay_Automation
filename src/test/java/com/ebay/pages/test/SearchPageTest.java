package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.ItemDescriptionPage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;
import com.ebay.pages.SearchPage;

public class SearchPageTest extends BaseSetup {

	LandingPage landingpage;
	AccountLinkPage accountlinkpage;
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	ItemDescriptionPage descpage;
	
	public SearchPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeClass
	public void InitialSetup() throws IOException, InterruptedException
	{
		desiredCapabilitiesSetup();
		landingpage = new LandingPage();
		loginpage = landingpage.clickSignInButton();
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
		homepage = accountlinkpage.doNotLinkAccount();
		searchpage = homepage.clickOnSearchBox();
	}
	
	
	@Test
	public void searchItemTest() throws IOException
	{
		descpage = searchpage.searchForAnItem(prop.getProperty("searchItem"));
	}
}
