package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.ItemDescriptionPage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;
import com.ebay.pages.OrderConfirmationPage;
import com.ebay.pages.OrderQuantityPage;
import com.ebay.pages.SearchPage;

public class OrderQuantityPageTest extends BaseSetup{

	
	LandingPage landingpage;
	LoginPage loginpage;
	AccountLinkPage accountlinkpage;
	HomePage homepage;
	SearchPage searchpage;
	ItemDescriptionPage descpage;
	OrderQuantityPage quantitypage;
	OrderConfirmationPage orderConfrmPage;
	
	
	public OrderQuantityPageTest() throws IOException
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
		Thread.sleep(6000);
		quantitypage = descpage.clickBuyItNow();
	}
	
	
	@Test(priority = 1)
	public void verifyQuantityPageTest()
	{
		boolean result = quantitypage.verifyQuantityPage();
		Assert.assertTrue(result, "true");
	}
	
	
	@Test(priority = 2)
	public void reviewOrder() throws IOException
	{
		orderConfrmPage = quantitypage.clickOnReviewOrder();
	}
}