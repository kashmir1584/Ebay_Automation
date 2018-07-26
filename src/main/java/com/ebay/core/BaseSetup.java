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

public class BaseSetup {
	
	public static AndroidDriver<WebElement> driver;
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static File file;
	public static DesiredCapabilities cap = new DesiredCapabilities();
	
	
	//Initial setup method
	public BaseSetup() throws MalformedURLException, IOException
	{
		file = new File(System.getProperty("user.dir")+"\\src\\main\\resources\\com\\ebay\\config\\Config.properties");
		fis = new FileInputStream(file);
		prop.load(fis);
	}
		
	
	public static void desiredCapabilitiesSetup() throws MalformedURLException {
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "emulator");
		cap.setCapability("appPackage", "com.ebay.mobile");
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("noReset",true);
		cap.setCapability("newCommandTimeout",5000);
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
}