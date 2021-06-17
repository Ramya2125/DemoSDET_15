package com.crm.comcast.GenericUtiles;

import java.io.File;

import java.io.FileReader;
import java.util.HashMap;
import org.json.simple.parser.JSONParser;
/**
 * @author Ramya R
 * This class has methods to read data from JSON file
 *
 */

public class JSONFileUtility {
	/**
	 * This method read data from JSON file
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromJSON(String key) throws Throwable
	{   
		//Read the data from JSON
		FileReader inputFile = new FileReader(IPathConstants.JSONPath);

		//parse the JSON object into java data stream
		JSONParser parser= new JSONParser();
		Object obj = parser.parse(inputFile);

		//type cast the object into Hashmap and read the data in key value format
		HashMap jobj=(HashMap)obj;
		String value = jobj.get(key).toString();
		return value;

	}

}
