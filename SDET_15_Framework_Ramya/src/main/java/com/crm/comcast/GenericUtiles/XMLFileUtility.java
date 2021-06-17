package com.crm.comcast.GenericUtiles;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;
/**
 * This class has methods to read data from XML file
 * @author Ramya R
 *
 */
public class XMLFileUtility {
	/**
	 * This method read data from XML file
	 * @author Ramya R
	 * @param node
	 * @return
	 * @throws DocumentException
	 */
	public String  ReadDatafromXML(String node) throws DocumentException 
	{
		//Read file from location
		File inputfile= new File(IPathConstants.XMLPath);

		//read the XML from input
		SAXReader reader=new SAXReader();
		Document doc = reader.read(inputfile);

		//Navigate to a Particular node to get the value
		String value = doc.selectSingleNode("//commondata/"+node).getText();
		return value;
		
		

	}

}
