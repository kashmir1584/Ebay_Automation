package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class ItemDescriptionPage extends BaseSetup {	
	
	@FindBy(name = "Buy It Now")
	WebElement buyItNowButton;
	
	@FindBy(id = "com.ebay.mobile:id/textview_item_name")
	WebElement descText;
	
	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	WebElement itemPrice;
	
	
	public ItemDescriptionPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getItemDescription()
	{
		String itemDescription = descText.getAttribute("content-desc");
		return itemDescription;
	}
	
	
	public String getItemPrice()
	{
		String price = itemPrice.getAttribute("content-desc");
		return price;
	}

	
	public OrderQuantityPage clickBuyItNow() throws IOException
	{
		buyItNowButton.click();
		return new OrderQuantityPage();
	}
	
	
}
