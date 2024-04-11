package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo1 {

	public static void main(String[] args) {
		
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user ="root";
		String password = "root";
		String SQL = "SELECT * from empolyee";
		
		
		
		try {
			Connection connection=DriverManager.getConnection(url, user, password);
			
			Statement statement = connection.createStatement();
			ResultSet rest = statement.executeQuery(SQL);
			System.out.println(rest);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
