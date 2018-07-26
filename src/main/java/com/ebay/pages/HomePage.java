package com.ebay.pages;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class HomePage extends BaseSetup{

	ItemDescriptionPage item_descpage;
	Random randNum = new Random();
	
	@FindBy(id = "com.ebay.mobile:id/search_box")
	WebElement searchbox;
	
	@FindBy(id = "com.ebay.mobile:id/button_all_recent")
	WebElement moreButton;
	
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean confirmHomePage()
	{
		boolean result = searchbox.isDisplayed();
		return result;
	}
	
	
	public SearchPage clickOnSearchBox() throws IOException
	{
		searchbox.click();
		return new SearchPage();
	}
}