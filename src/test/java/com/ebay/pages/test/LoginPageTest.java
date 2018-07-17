package com.ebay.pages.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;

public class LoginPageTest extends BaseSetup {

	LoginPage loginpage;
	LandingPage landingpage;
	AccountLinkPage accountlinkpage;
	
		
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		landingpage = new LandingPage();
		
		//in order to reach login page, first user needs to click SignIn button on landing page
		loginpage = landingpage.clickSignInButton();
	}
	
	
	@Test(priority = 1)
	public void verifyLoginPageTest()
	{
		boolean value = loginpage.verifyLoginPage();
		Assert.assertEquals(value, "true");
	}
	
	
	@Test(priority = 2)
	public void loginTest() throws IOException
	{
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	//using TestNG DataProvider to get the data fetched from excel sheet
	/*@Test(priority = 2, dataProvider="getTestData")
	public void loginTest(String username, String password) throws IOException
	{
		accountlinkpage = loginpage.LoginIntoAccount(username, password);
	}*/
	
	
	//using dataProvider annotation to get the data from external source
	/*@DataProvider
	public Iterator<Object[]> getTestData() throws IOException
	{
		ArrayList<Object[]> testdata = TestUtil.getExcelData();
		return testdata.iterator();
	}*/	
	
	
}