package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo6 {

	private static Connection connection;
	private static PreparedStatement statement;
	private static int rest;
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password = "root";
		
		String SQL = "UPDATE `empolyee` "
				+ "SET `E_SALARY` = `E_SALARY` + ?"
				+ " WHERE `E_DEPT` = ?";
		
		try {
			connection=DriverManager.getConnection(url, user, password);
			
			demo3.display(connection, statement, null);
			statement = connection.prepareStatement(SQL);
			
			
			System.out.println("enter the increment:");
			int sal= scan.nextInt();
			System.out.println("enter the department name :");
			String E_DEPT= scan.next();
			
			statement.setInt(1, sal); 
			statement.setString(2, E_DEPT); 
			
			int i = statement.executeUpdate();
			
			System.out.println(i +"\n");
			
			
			demo3.display(connection, statement, null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		

	}

	}
}
	
