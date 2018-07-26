package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class OrderQuantityPage extends BaseSetup{

	
	@FindBy(id = "com.ebay.mobile:id/take_action")
	WebElement reviewButton;
	
	@FindBy(id = "android:id/numberpicker_input")
	WebElement orderTextbox;
	
	
	public OrderQuantityPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyQuantityPage()
	{
		boolean result = orderTextbox.isDisplayed();
		return result;
	}
	
	
	public OrderConfirmationPage clickOnReviewOrder() throws IOException
	{
		reviewButton.click();
		return new OrderConfirmationPage();
	}
}