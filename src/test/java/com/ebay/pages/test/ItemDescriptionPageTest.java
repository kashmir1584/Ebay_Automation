package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.HomePage;
import com.ebay.pages.ItemDescriptionPage;

public class ItemDescriptionPageTest extends BaseSetup {

	
	HomePage homepage;
	ItemDescriptionPage descpage;
	
	
	
	public ItemDescriptionPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		homepage = new HomePage();
		descpage = homepage.searchAnItem(prop.getProperty("searchItem"));
	}
	
	
	@Test
	public void getItemPriceTest()
	{
		String result = descpage.getItemPrice();
		System.out.println("searched item price is :: " +result);
	}
	
	
	@Test
	public void getItemDescriptionTest()
	{
		String result = descpage.getItemDescription();
		System.out.println("searched item description is :: " +result);
	}
	
}