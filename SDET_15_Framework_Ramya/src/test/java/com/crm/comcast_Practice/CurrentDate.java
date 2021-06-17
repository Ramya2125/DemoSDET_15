package com.crm.comcast_Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CurrentDate{

	public static void main(String args[]) {
		Date dateobj=new Date();
		String todaysdate = dateobj.toString();
		String[]arr=todaysdate.split(" ");

		String day=arr[0];
		String month=arr[1];
		String date=arr[2];
		String year=arr[5];

		String traveldate=day+" "+month+" "+date+" "+year;

						
		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		driver.manage().window().maximize();
		
		Actions a=new Actions(driver);
		a.moveByOffset(10, 10).click();

		//select from city and to city 
		WebElement scr = driver.findElement(By.id("fromCity"));
		WebElement desc = driver.findElement(By.id("toCity"));
				
		scr.sendKeys("Mumbai");
		driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();

		desc.sendKeys("Chennai");
		driver.findElement(By.xpath("//div[contains(text(),'MAA')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//To enter current date
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Jun 09 2021']")).click();
		
		System.out.println(traveldate);
		
		
		
		
	




	}




}
