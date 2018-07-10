package com.ebay.pages.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;

import com.ebay.core.BaseSetup;
import com.ebay.pages.AccountLinkPage;
import com.ebay.pages.LoginPage;

public class AccountLinkPageTest extends BaseSetup{
	
	LoginPage loginpage;
	AccountLinkPage accountlinkpage;
	
	public AccountLinkPageTest() throws IOException
	{
		super();
	}

	
	@BeforeMethod
	public void InitialSetup() throws IOException
	{
		loginpage = new LoginPage();
		accountlinkpage = loginpage.LoginIntoAccount(prop.getProperty("username"), prop.getProperty("password"));
	}
}
