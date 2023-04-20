package com.zsgs.crm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Summa {

	public static void main(String[] args) throws SQLException {
		//connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","Aadhisql@1312");
		
		//create query
		Statement stmt = con.createStatement();
		String s = "SELECT name,age from Details";
		
		//execute query
//		stmt.execute(s);
		
		//execute query and store data in result set for select query
		ResultSet rs = stmt.executeQuery(s);
		
		while(rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			System.out.println("Name - " + name + " : Age - " + age);
		}
		
		//close connection
		con.close();
		
		System.out.println("Query executed");
	}
}
