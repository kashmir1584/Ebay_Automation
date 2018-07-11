package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class OrderConfirmationPage extends BaseSetup {

	@FindBy(id = "")
	WebElement itemdescription;
	
	@FindBy(id = "")
	WebElement price;
	
	ItemDescriptionPage descpage = new ItemDescriptionPage();
	
	
	public OrderConfirmationPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getOderFinalPrice()
	{
		String finalPrice = price.getAttribute("content-desc");
		return finalPrice;
	}
	
	
	public String getOderFinalDescription()
	{
		String finalDescription = itemdescription.getAttribute("content-desc");
		return finalDescription;
	}
	
	
	public boolean compareItemOrderDetails()
	{
		if((descpage.getItemDescription()).equals("finalDescription")
				&& (descpage.getItemPrice()).equals("finalPrice"))
		{
			return true;
		}else
		{
			return false;
		}
	}
}
