package com.crm.comcast_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;


public class SampleJDBCExecuteQuery {
	@Test

	public void DatabaseExecuteQuery() throws Throwable  {

		//step1: Register to Database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		//step2: get connection with database-provide database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET", "root","root");

		//step3: issue create statement
		Statement stat = conn.createStatement();

		//step 4: Execute any query-provide table name
		ResultSet result = stat.executeQuery("select * from employee;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
		}
		
		//step 5: close the database

		conn.close();
	}


	
}
