package com.crm.comcast.opportunityTest;

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
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtiles.JavaUtility;
import com.crm.comcast.GenericUtiles.XMLFileUtility;

public class TC_46_DeleteMultipleOpportunitiesTest {
	@Test
	public void TC_46_DeleteMultipleOpportunitiesTest() throws Throwable {
		WebDriver driver;
		XMLFileUtility xmlLib=new XMLFileUtility();
		JavaUtility jLib=new JavaUtility();

		int random = jLib.getRandomNumber();
		String USERNAME = xmlLib.ReadDatafromXML("username");
		String PASSWORD = xmlLib.ReadDatafromXML("password");
		String URL = xmlLib.ReadDatafromXML("url");
		String BROWSER = xmlLib.ReadDatafromXML("browser");

		//Launch the browser
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();

		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();

		}else {
			driver=new InternetExplorerDriver();

		}
		//Navigate to URL
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();

		//Login to Vtiger Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to Opportunities
		driver.findElement(By.linkText("Opportunities")).click();

		//create new Opportunities 
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();

		//Enter Mandatory fields
		driver.findElement(By.name("potentialname")).sendKeys("Anu"+random);

		WebElement RelatedTo = driver.findElement(By.className("dvtCellLabel"));
		Actions a=new Actions(driver);
		a.moveToElement(RelatedTo).perform();

		//Selecting contact from drop down

		WebElement contact = driver.findElement(By.id("related_to_type"));
		Select s=new Select(contact);
		s.selectByValue("Contacts");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String childwindow = driver.getWindowHandle();
		Thread.sleep(1000);
		driver.switchTo().window(childwindow);

		// Set dd//mm//yyyy from calendar pop up

		WebElement calendar = driver.findElement(By.className("dvtCellLabel"));
		Actions a2=new Actions(driver);
		a2.moveToElement(calendar).perform();
		String month="January 2018";
		String Date="09";
		driver.findElement(By.id("jscal_trigger_closingdate")).click();

		//save the opportunity
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		System.out.println("Campaign information updated today");

		//click on opportunity module
		driver.findElement(By.linkText("Opportunities")).click();

		//Click on Advance search using moveover Action
		WebElement Advance = driver.findElement(By.linkText("Go to Advanced Search"));
		Actions a3=new Actions(driver);
		a3.moveToElement(Advance).click();

		//select from dropdown
		WebElement dropdown = driver.findElement(By.className("detailedViewTextBox"));
		Select s1=new Select(dropdown);
		s.selectByValue("Expected Close Date");

		//Logout from Vitiger
		driver.findElement(By.linkText("Sign Out")).click();		










	}
}
