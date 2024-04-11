package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo4 {
	
	public static void main(String[]args) {
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password = "root";
		String SQL = "INSERT into empolyee"
				+ " (`E_ID`,`E_NAME`,`E_EMAIL`,`E_DEPT`,`E_SALARY`) values"
				+ " (13,'jiraya','jiraya12@gmail.com','teacher',500000)";
		
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statemnt = connection.createStatement();
			int rest = statemnt.executeUpdate(SQL);
			System.out.println(rest);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
