package com.crm.comcast_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {
	@Test
	
	public void DatabaseExecuteUpdate() throws Throwable  {
		

		//step1: Register to Database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		//step2: get connection with database-provide database name
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET", "root","root");

		//step3: issue create statement
		Statement stat = conn.createStatement();

		//step 4: Execute any query-provide table name
		int result = stat.executeUpdate("insert into employee values ('Anu','123456789','Begur');");
		 if(result==1)
		 {
			 System.out.println("query successfully -1 row added");
		 }
		 else
		 {
			 System.out.println("Query failed");
		 }
		
		//step 5: close the database

		conn.close();
	}

}
