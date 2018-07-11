package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.ItemDescriptionPage;
import com.ebay.pages.OrderConfirmationPage;
import com.ebay.pages.OrderQuantityPage;

public class OrderQuantityPageTest extends BaseSetup{

	ItemDescriptionPage descpage;
	OrderConfirmationPage orderConfrmPage;
	OrderQuantityPage quantitypage;
	
	
	public OrderQuantityPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		descpage = new ItemDescriptionPage();
		orderConfrmPage = new OrderConfirmationPage();
		
		quantitypage = descpage.addToCart();
	}
	
	@Test
	public void setOrderQuantityTest()
	{
		quantitypage.setOrderQuantity();
	}
}
