package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.OrderConfirmationPage;
import com.ebay.pages.OrderQuantityPage;

public class OderConfirmationPageTest extends BaseSetup {

	
	OrderConfirmationPage orderConfrmPage;
	OrderQuantityPage quntitypage;
	
	public OderConfirmationPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		orderConfrmPage = quntitypage.reviewOrder();
	}
	
	
	@Test
	public void getItemDescriptionTest()
	{
		String itemdesc = orderConfrmPage.getOderFinalDescription();
		System.out.println("item final description :: " +itemdesc);
	}
	
	
	@Test
	public void getItemPriceTest()
	{
		String itemprice = orderConfrmPage.getOderFinalPrice();
		System.out.println("item final price :: " +itemprice);
	}
	
	@Test
	public void compareDetailsTest()
	{
		boolean result = orderConfrmPage.compareItemOrderDetails();
		Assert.assertEquals(result, "true");
	}	
}