package com.crm.comcast.GenericUtiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.ObjectRepository.HomePage;
import com.crm.comcast.ObjectRepository.LoginPage;

public class BaseClass {
	public DatabaseUtility dLib = new DatabaseUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public JSONFileUtility jsLib = new JSONFileUtility();
	public XMLFileUtility xLib =  new XMLFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriver driver;
	public HomePage homepage;
	
	
	@BeforeSuite(groups = {"SmokeTest","regressionTest"})
	public void makeDBConnection() throws Throwable
	{
		//dLib.connectToDB();
		System.out.println("========make database connection=====");
	}
	
	@BeforeClass(groups = {"SmokeTest","regressionTest"})
	public void launchBrowser() throws Throwable
	{
		String BROWSER = xLib.ReadDatafromXML("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			driver = new InternetExplorerDriver();
		}
		
	}
		
	@BeforeMethod(groups = {"SmokeTest","regressionTest"})
	public void loginTtoApp() throws Throwable
	{
		String USERNAME = xLib.ReadDatafromXML("username");
		String PASSWORD = xLib.ReadDatafromXML("password");
		String URL = xLib.ReadDatafromXML("url");
		
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		wLib.maximiseWin(driver);
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(USERNAME, PASSWORD);
		
		
	}
	
	
    @AfterMethod(groups = {"SmokeTest","regressionTest"})
    public void logoutOfApp()
    {
    	homepage.signOut();
    }
    
    @AfterClass(groups = {"SmokeTest","regressionTest"})
    public void closeBrowser()
    {
    	driver.close();
    }
    
    @AfterSuite(groups = {"SmokeTest","regressionTest"})
    public void closeDB() throws Throwable
    {
    	//dLib.closeDB();
    	System.out.println("=====close the DB connection======");
    }

	
	

}
