package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.HomePage;
import com.ebay.pages.ItemDescriptionPage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;
import com.ebay.pages.OrderConfirmationPage;
import com.ebay.pages.OrderQuantityPage;

public class OrderQuantityPageTest extends BaseSetup{

	
	LandingPage landingpage;
	LoginPage loginpage;
	AccountLinkPage accountlinkpage;
	HomePage homepage;
	ItemDescriptionPage descpage;
	OrderQuantityPage quantitypage;
	OrderConfirmationPage orderConfrmPage;
	
	
	public OrderQuantityPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		landingpage = new LandingPage();
		loginpage = landingpage.clickSignInButton();
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
		homepage = accountlinkpage.doNotLinkAccount();
		descpage = homepage.searchAnItem(prop.getProperty("searchItem"));
		descpage = new ItemDescriptionPage();
		quantitypage = descpage.clickBuyItNow();
	}
	
	
	@Test(priority = 1)
	public void verifyQuantityPageTest()
	{
		boolean result = quantitypage.verifyQuantityPage();
		Assert.assertTrue(result, "true");
	}
	
	
	@Test(priority = 2)
	public void setOrderQuantityTest()
	{
		quantitypage.setOrderQuantity();
	}
	
	
	@Test(priority = 3)
	public void reviewOrder() throws IOException
	{
		orderConfrmPage = quantitypage.clickOnReviewOrder();
	}
	
	
	/*@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}*/
}
