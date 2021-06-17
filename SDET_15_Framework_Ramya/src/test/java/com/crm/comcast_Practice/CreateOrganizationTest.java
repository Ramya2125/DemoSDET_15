package com.crm.comcast_Practice;

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
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class CreateOrganizationTest extends BaseClass{
@Test
public void CreateOrganization() throws Throwable {
	
	JavaUtility jLib=new JavaUtility();
	
	int random = jLib.getRandomNumber();
	
	//Navigate to the organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//Navigate to create Organization
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//Enter mandatory fields and create organization
	driver.findElement(By.name("accountname")).sendKeys("Ty"+random);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//validate
	String SuccessMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue(SuccessMsg.contains("Ty"));
	System.out.println(SuccessMsg);
	
		
}
}
