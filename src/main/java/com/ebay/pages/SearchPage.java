package com.ebay.pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class SearchPage extends BaseSetup{

	
	@FindBy(id = "com.ebay.mobile:id/search_src_text")
	WebElement searchbox;
	
	@FindBy(id = "com.ebay.mobile:id/textview_item_count")
	WebElement resultCount;
	
	@FindAll(@FindBy(xpath = "//*[@resource-id='com.ebay.mobile:id/cell_collection_item']"))
	List<WebElement> searchResult;
	
	ItemDescriptionPage item_descpage;
	
	Random randNum = new Random();
	
	public SearchPage() throws IOException 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public ItemDescriptionPage searchForAnItem(String item) throws IOException
	{
		searchbox.sendKeys(item +"\n");
		resultCount.click();
		
		int list_size = searchResult.size() -1;
		
		System.out.println("searched list size is -- " +list_size);
		int index = randNum.nextInt(searchResult.size());
		System.out.println("index found is --"+index);
		
			if(searchResult.get(index).isDisplayed())
			{
				System.out.println("element visible on the screen, driver not scrolling");
				searchResult.get(index).click();
			}
			else {
				System.out.println("driver going to scroll down till the element");
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].scrollIntoView(true);", searchResult.get(index));
				searchResult.get(index).click();
			}
		return new ItemDescriptionPage();
	}
}