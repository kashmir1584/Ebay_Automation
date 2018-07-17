package com.ebay.utility;

import java.io.IOException;
import java.util.ArrayList;

public class TestUtil {

	
	public static ArrayList<Object[]> getExcelData() throws IOException
	{
		//Storing the excel data in an arraylist of Object
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		//fetching the data from the specified file path
		ReadingExcelFileData exceldata = new ReadingExcelFileData("F:\\Ebay_Automation\\com.ebay.mobile.app.test\\src\\main\\resources\\TestData.xlsx");
		
		for(int i = 2; i <= exceldata.RowCount(0); i++)
		{
			String username = exceldata.getdata("Data", i, "Username");
			String password = exceldata.getdata("Data", i, "Password");
			
			System.out.println("username and password :: " + username + "   " +password);
			
			Object[] data = {username, password};
			mydata.add(data);
		}
		return mydata;
		
	}
}
