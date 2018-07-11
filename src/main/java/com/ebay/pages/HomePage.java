package com.ebay.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
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
	
	TouchActions action = new TouchActions(driver);
	
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
		
		List<WebElement> searchItemList = driver.findElements(By.xpath("android.widget.FrameLayout[@index='0']/android.widget.RelativeLayout"));
		int list_size = searchItemList.size();
		for(int i =0; i < list_size; i++)
		{
			if(searchItemList.get(randNum.nextInt(list_size)).isDisplayed())
			{
				searchItemList.get(randNum.nextInt(list_size)).click();
			}
			else {
				action.scroll(searchItemList.get(randNum.nextInt(list_size)), 10, 100);
				action.perform();
				searchItemList.get(randNum.nextInt(list_size)).click();
			}
		}
		return new ItemDescriptionPage();
	}
	
	
	public ItemDescriptionPage searchItem(String item) throws IOException
	{
		searchbox.sendKeys(item);
		searchbox.sendKeys(Keys.ENTER);
		
		List<WebElement> searchItemList = driver.findElements(By.xpath("android.widget.FrameLayout[@index='0']"));
		int list_size = searchItemList.size();
		WebElement element = searchItemList.get(randNum.nextInt(list_size));
		for(int i =0; i < list_size; i++)
		{
			if(element.isDisplayed())
			{
				element.click();
			}
			else {
				scrollToAnElement(element);
				element.click();
			}
		}
		return new ItemDescriptionPage();
	}
	
	public void scrollToAnElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", scrollObject);
	}
}