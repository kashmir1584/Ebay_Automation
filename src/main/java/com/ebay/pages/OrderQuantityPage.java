package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class OrderQuantityPage extends BaseSetup{

	
	@FindBy(id = "")
	WebElement reviewButton;
	
	@FindBy(id = "")
	WebElement orderTextbox;
	
	
	public OrderQuantityPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyQuantityPage()
	{
		boolean result = reviewButton.isDisplayed();
		return result;
	}
	
	public OrderConfirmationPage reviewOrder() throws IOException
	{
		reviewButton.click();
		return new OrderConfirmationPage();
	}
	
	public void setOrderQuantity()
	{
		//orderTextbox.sendKeys("2");
		System.out.println("do nothing");
	}
}
