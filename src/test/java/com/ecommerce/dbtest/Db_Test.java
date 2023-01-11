package com.ecommerce.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.ecommerce.utilities.ReadConfig;

public class Db_Test {
	ResultSet rs; 
	String firstName;
	String lastName;
	String address;
	String city;
	String pincode;
	String email;
	
	@Test
	public String[] db() throws SQLException
	{
		ReadConfig readConfig = new ReadConfig();
		String url=readConfig.getDbUrl();
		String un=readConfig.getDbUn();
		String pwd= readConfig.getDbPwd();
		
		Connection conn = DriverManager.getConnection(url,un,pwd);
		Statement stmt = conn.createStatement();
		String s1 = "select * from Billingdetails where fn='Ram'";
		rs = stmt.executeQuery(s1);
		while(rs.next())
		{
			firstName = rs.getString("fn");
			lastName = rs.getString("ln");
			address = rs.getString("address");
			city = rs.getString("city");
			pincode = rs.getString("pincode");
			email = rs.getString("email");
		}
		String []arr={firstName,lastName,address,city,pincode,email};
		return arr;
	}	
}
