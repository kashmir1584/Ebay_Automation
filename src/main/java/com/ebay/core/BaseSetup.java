package com.ebay.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseSetup {
	
	public static AndroidDriver<WebElement> driver;
//	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static File file;
	DesiredCapabilities cap = new DesiredCapabilities();
	
	
	//Initial setup method
	public BaseSetup() throws MalformedURLException, IOException
	{
		file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\ebay\\config\\Config.properties");
		fis = new FileInputStream(file);
		prop.load(fis);
		
		
		cap.setCapability("platformName", "Android");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		cap.setCapability("deviceName", "emulator");
		//cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
		cap.setCapability("appPackage", "com.ebay.mobile");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	//	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
