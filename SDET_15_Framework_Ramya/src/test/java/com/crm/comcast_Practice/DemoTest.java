package com.crm.comcast_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.ObjectRepository.LoginPage;

public class DemoTest {
	@Test
	public void demotest() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		
		LoginPage lp=new LoginPage(driver);
		lp.login("admin", "admin");
		
		
	}

}
