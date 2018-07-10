package com.ebay.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebay.core.BaseSetup;

public class HomePage extends BaseSetup{

	
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
		boolean result = moreButton.isDisplayed();
		return result;
	}
	
	
	public ItemDescriptionPage searchAnItem(String item) throws IOException
	{
		searchbox.sendKeys(item);
		searchbox.sendKeys(Keys.ENTER);
		
		List<WebElement> searchItemList = driver.findElements(By.xpath("android.widget.FrameLayout[@index='0']"));
		for(WebElement element : searchItemList)
		{
			String itemDescription = element.getText();
		}
		return new ItemDescriptionPage();
	}
	
	
	
}
