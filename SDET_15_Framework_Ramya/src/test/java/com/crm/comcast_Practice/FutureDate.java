package com.crm.comcast_Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FutureDate {
	@Test
	public void FutureDate() {

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		desc.sendKeys("Chennai");
		driver.findElement(By.xpath("(//div[.='MAA'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();

		for(;;) {
			try {
				driver.findElement(By.xpath("//div[@aria-label='Sat Oct 09 2021']")).click();
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}

	}
}
