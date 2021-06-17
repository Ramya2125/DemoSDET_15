package com.crm.comcast_Practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGDemo {

	@Test(priority=1)
	public void CreateUser()
	{
		System.out.println("user created successfully");
		Reporter.log("user created");
	}
	
	@Test(priority=3,dependsOnMethods="CreateUser")
	public void ModifyUser()
	{
		System.out.println("user successfully modified");
		Reporter.log("modify User");
	}
	
	@Test(invocationCount=3)
	public void DeleteUser()
	{
		System.out.println("User deleted succesfully");
	}
}
