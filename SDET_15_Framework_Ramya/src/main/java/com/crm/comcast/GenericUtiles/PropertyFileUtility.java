package com.crm.comcast.GenericUtiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/** 
 * @author Ramya R
 * This class has methods to read data from Property file
 *
 */

public class PropertyFileUtility {
	/**
	 * This method read data from Property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDatafromPropertyFile(String key) throws Throwable  {
		FileInputStream file =new FileInputStream(IPathConstants.PropertFilePath);
		Properties prop=new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		System.out.println(value);
		return value;

	}
}
