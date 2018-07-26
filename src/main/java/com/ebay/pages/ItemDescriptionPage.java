package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class ItemDescriptionPage extends BaseSetup {	
	
	@FindBy(id="com.ebay.mobile:id/button_bin")
	WebElement buyItNowButton;
	
	@FindBy(id = "com.ebay.mobile:id/textview_item_name")
	WebElement descText;
	
	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	WebElement itemPrice;
	
	public static String itemDescription, price;
	
	public ItemDescriptionPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getItemDescription()
	{
		itemDescription = descText.getAttribute("text");
		return itemDescription;
	}
	
	
	public String getItemPrice()
	{
		price = itemPrice.getAttribute("text");
		return price;
	}

	
	public OrderQuantityPage clickBuyItNow() throws IOException
	{
		String description  = getItemDescription();
		String value = getItemPrice();
		System.out.println("item description -- " +description);
		System.out.println("item price -- "+value);
		buyItNowButton.click();
		return new OrderQuantityPage();
	}	
}