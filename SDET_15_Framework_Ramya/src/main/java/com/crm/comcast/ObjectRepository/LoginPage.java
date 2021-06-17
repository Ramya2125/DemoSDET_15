package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//step 1: Create seperate java class for every page in the Application

	public LoginPage(WebDriver driver) //Rule-4 : Create Constructor to itialize the Element
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")//Rule-2: Go to every page in an app. & identify all elements using @findBy, @findBys & @findAll annotations & store them in specific java class in POM
	private WebElement utbx;

	@FindBy(name="user_password")
	private WebElement pwtxb;

	@FindBy(id="submitButton")
	private WebElement lgbtn;	

	public WebElement getUtbx() {	////Rule-3: As per POM, Declare all element as Private & provide public getters methods to give read access to test scripts.right click->source->generate getter and setter and select thecheckbox and click on apply
		return utbx;
	}

	public WebElement getPwtxb() {
		return pwtxb;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	
	public void login(String username,String password) { // Rule-5: In all testscripts Utilize the element using getter(), Business method.
		utbx.sendKeys(username);
		pwtxb.sendKeys(password);
		lgbtn.click();
		
	}




}
