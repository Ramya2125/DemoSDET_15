package com.crm.comcast_Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtiles.JavaUtility;
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class DynamicWebTable {
	@Test
	public void DynamicWebTable() throws Throwable {
		WebDriver driver;
		XMLFileUtility xmlLib=new XMLFileUtility();
		JavaUtility jLib=new JavaUtility();
		
		int random = jLib.getRandomNumber();
		String URL = xmlLib.ReadDatafromXML("url");
		String USERNAME = xmlLib.ReadDatafromXML("username");
		String PASSWORD = xmlLib.ReadDatafromXML("password");
		String BROWSER = xmlLib.ReadDatafromXML("browser");
		//Launch browser
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
			}else if(BROWSER.equals("firefox")) {
				driver=new FirefoxDriver();
			}else {
				driver=new InternetExplorerDriver();
			}
		
		//Navigate the URL
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)	;
		driver.get(URL);
		driver.manage().window().maximize();
		
		
		//Login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Navigate to the organization
		driver.findElement(By.linkText("Organizations")).click();
		
		//click on all the check boxes
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for(int i=1;i<list.size();i++) {
			list.get(i).click();
		}
		
		//click on last check box
		List<WebElement> lis = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		lis.get(lis.size()-1).click();
		
		//Click on 3rd row check box
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[5]/td[1]/input")).click();
		
		//select only first 5 check box
		List<WebElement> lst = driver.findElements(By.xpath("\"//table[@class='lvt small']/tbody/tr[*]/td[1]/input\""));
		for(int i=1;i<lst.size();i++) {
			lst.get(i).click();
			
		}
		//print all organization name on console
		List<WebElement> list2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		String expData = "ch";
		int actDataCount =0;
		
		for(WebElement ls : list2)	
		{
			String actData = ls.getText();
			if(expData.equalsIgnoreCase(actData))
			{
				break;
			}
			actDataCount++;
		}
		
		System.out.println(actDataCount);
        driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(actDataCount+2)+"]/td[8]/a[.='del']")).click();
		}
		
	}


