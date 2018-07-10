package com.ebay.pages.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.LandingPage;
import com.ebay.pages.LoginPage;
import com.ebay.utility.ReadingExcelFileData;

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
		accountlinkpage = new AccountLinkPage();
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
	
	//using TestNG DataProvider to get the data fetched from excel sheet
	@Test(dependsOnMethods = {"verifyLoginPageTest"}, dataProvider="getExcelData")
	public void loginTest(String username, String password) throws IOException
	{
		accountlinkpage = loginpage.LoginIntoAccount(username, password);
	}
	
	
	//using dataProvider annotation to get the data from external source
	@DataProvider()
	public Iterator<Object[]> getExcelData() throws IOException
	{
		//Storing the excel data in an arraylist of Object
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		//fetching the data from the specified file path
		ReadingExcelFileData exceldata = new ReadingExcelFileData("F:\\Ebay_Automation\\com.ebay.mobile.app.test\\src\\test\\resources\\com\\ebay\\testdata\\TestData.xlsx");
		
		for(int i = 1; i < exceldata.RowCount(0); i++)
		{
			String username = exceldata.getdata("Data", i, "Username");
			String password = exceldata.getdata("Data", i, "Password");
			
			Object[] data = {username, password};
			mydata.add(data);
		}
		return mydata.iterator();
		
	}
}
