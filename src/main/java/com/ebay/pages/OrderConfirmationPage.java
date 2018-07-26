package com.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class OrderConfirmationPage extends BaseSetup {

	ItemDescriptionPage descpage = new ItemDescriptionPage();
	
	public OrderConfirmationPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean compareItemOrderDetails() throws InterruptedException
	{
		String description = ItemDescriptionPage.itemDescription;
		String price = ItemDescriptionPage.price;
		String val = price.replaceAll("\u20B9", "Rs");
		System.out.println("new price --" +val);
		System.out.println("item description from description page -- " +description);
		System.out.println("item price from description page -- "+ price);
		
		MobileElement scrollTo = (MobileElement)driver.findElement(MobileBy
                .AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                        + "new UiSelector().text(\""+ description + "\"));"));
		
		if(scrollTo.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
	}
	
	
	public static WebElement elementToText(String text) {
    	WebElement element = null;
    	try {
    		 element=driver.findElement(By.xpath("//*[contains(@text,'"+text+"')]"));
		} catch (Exception e) {
			
		}
		return element;
	}
}