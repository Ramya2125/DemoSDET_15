package com.crm.comcast.VtigetTest;

import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtiles.BaseClass;
import com.crm.comcast.GenericUtiles.JavaUtility;
import com.crm.comcast.GenericUtiles.WebDriverUtility;
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class CreateOrganizationWithIndustry extends BaseClass {
	
	@Test (groups="regression")
	public void CreateOrganizationWithIndustry() throws Throwable {
		
		int random = jLib.getRandomNumber();
		
		//Navigate to the Organization
		driver.findElement(By.linkText("Organizations")).click();

		//Navigate to Create Organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//Enter Mandatory fields and select education from dropdown list
		driver.findElement(By.name("accountname")).sendKeys("ABC"+random);

		//Mouseover Action on Industry
		WebElement industry = driver.findElement(By.className("dvtCellLabel"));
		wLib.mouseOver(driver, industry);

		//Select Education from dropdown using select class
		WebElement dropdown = driver.findElement(By.name("industry"));
		wLib.select(dropdown, "Education");

		//click on save 
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Validate 
		String Succesfullyupdated = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(Succesfullyupdated.contains("ABC"));
		System.out.println(Succesfullyupdated);











	}

}
