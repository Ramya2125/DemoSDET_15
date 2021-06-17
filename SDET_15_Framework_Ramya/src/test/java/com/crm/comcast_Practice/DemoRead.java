package com.crm.comcast_Practice;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtiles.DatabaseUtility;
import com.crm.comcast.GenericUtiles.ExcelUtility;
import com.crm.comcast.GenericUtiles.JSONFileUtility;
import com.crm.comcast.GenericUtiles.PropertyFileUtility;
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class DemoRead {
@Test
public void demoproperty() throws Throwable {
	PropertyFileUtility pLib=new PropertyFileUtility();
	
	JSONFileUtility jsonLib= new JSONFileUtility();
	
	XMLFileUtility xmlLib=new XMLFileUtility();
	
	DatabaseUtility dLib=new DatabaseUtility();
	
	ExcelUtility eLib=new ExcelUtility();
	
	String USERNAME = pLib.readDatafromPropertyFile("username");
	System.out.println(USERNAME);
	
	String URL = jsonLib.readDataFromJSON("url");
	System.out.println(URL);
	
	String PASSWORD = xmlLib.ReadDatafromXML("password");
	System.out.println(PASSWORD);
	
	String value = dLib.executeQueryAndGetData("select * from employee;", 1, "Ramya");
	System.out.println(value);
	dLib.closeDB();
	
	
}
}
