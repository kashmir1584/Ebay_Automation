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
import com.ebay.pages.OrderQuantityPage;
import com.ebay.pages.SearchPage;

public class ItemDescriptionPageTest extends BaseSetup {

	LandingPage landingpage;
	LoginPage loginpage;
	AccountLinkPage accountlinkpage;
	HomePage homepage;
	SearchPage searchpage;
	ItemDescriptionPage descpage;
	OrderQuantityPage quantitypage;
	
	
	public ItemDescriptionPageTest() throws IOException
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
		descpage = searchpage.searchForAnItem(prop.getProperty("searchItem"));
	}
	
	
	@Test(priority = 1)
	public void getItemPriceTest()
	{
		String result = descpage.getItemPrice();
		System.out.println("searched item price is :: " +result);
	}
	
	
	@Test(priority = 2)
	public void getItemDescriptionTest()
	{
		String result = descpage.getItemDescription();
		System.out.println("searched item description is :: " +result);
	}
	
	
	@Test(priority = 3)
	public void addToCart() throws IOException
	{
		quantitypage = descpage.clickBuyItNow();
	}
}