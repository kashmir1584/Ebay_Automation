package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class ItemDescriptionPage extends BaseSetup {
	
	HomePage homepage;
	ItemDescriptionPage descpage;
	
	
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
	
	
	public boolean compareValues()
	{
		String itemDescription = descText.getAttribute("content-desc");
		String Price = itemPrice.getAttribute("content-desc");
		
		if(itemDescription.equals("") && Price.equals(""))
		{
			return true;
		}else
			return false;
	}

	
	public void addToCart()
	{
		buyItNowButton.click();
	}
	
	
}
