package com.crm.comcast.GenericUtiles;

import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;
/**
 * 
 * This method has java related generic methoda like getRandomNumber
 * @author Ramya R
 *
 */
public class JavaUtility {
	
	/**
	 * This method will return a Randomnumber
	 * @author Ramya R
	 * @return
	 */

	public int getRandomNumber() {
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ran;

	}

	//To get currentDate
	public String getCurrentDate() {
		Date dateobj=new Date();
		String todaysdate = dateobj.toString();
		return todaysdate;
	}
	//To get currentYear
	public String getcurrentyear() {
		Date dateobj=new Date();
		String currentyear = dateobj.toString();
		String[]arr=currentyear.split(" ");
		return arr[5];
	}
	//To get currentMonth
	public String getcurrentMonth() {
		Date dateobj=new Date();
		String currentmonth = dateobj.toString();
		String[]arr=currentmonth.split(" ");
		return arr[1];

	}
	//To get currentDay
	private String getCurrentDay() {
		Date dateobj=new Date();
		String currentday =dateobj.toString();
		String[]arr=currentday.split(" ");
		return arr[0];
	}



}
