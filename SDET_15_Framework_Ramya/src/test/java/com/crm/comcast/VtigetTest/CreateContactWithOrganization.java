package com.crm.comcast.VtigetTest;

import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtiles.BaseClass;
import com.crm.comcast.GenericUtiles.JavaUtility;
import com.crm.comcast.GenericUtiles.WebDriverUtility;
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class CreateContactWithOrganization extends BaseClass{

	@Test(groups = "SmokeTest")
	public void CreateContactWithOrganization() throws Throwable  {
						
		int random = jLib.getRandomNumber();
												
		//Navigate to Contact
		driver.findElement(By.linkText("Contacts")).click();
		
		//Navigate to create Contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		
		//Enter mandatory feilds and create contact
		driver.findElement(By.name("lastname")).sendKeys("Ramya"+random);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Validate 
		String Successfullyupdated = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(Successfullyupdated.contains("Ramya"));
		System.out.println(Successfullyupdated);
		
		
		
		





	}

}
