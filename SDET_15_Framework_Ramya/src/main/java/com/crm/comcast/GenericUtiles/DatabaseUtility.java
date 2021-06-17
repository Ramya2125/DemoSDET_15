package com.crm.comcast.GenericUtiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DatabaseUtility {
	Connection con=null;
	ResultSet result=null;
	/**
	 * This method will establish connection between database
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException {

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET", "root", "root");
	}

	/**
	 * This method will the database connection
	 * @throws SQLException 
	 * 
	 */
	public void closeDB() throws SQLException {
		con.close();
	}

	public String executeQueryAndGetData(String query,int columnName,String expData) throws SQLException {
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnName).equalsIgnoreCase(expData)) {
				flag=true;
				break;

			}
		}
			if(flag) {
				System.out.println(expData +"Data verified in database");
				return expData;
			}
			else
			{
				System.out.println(expData +"Data not verified");
				return expData;

			}				
	}
	
	
}

