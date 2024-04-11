package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo5scanner {
	private static Connection connection;
    private static PreparedStatement statement;

	private static ResultSet rest;

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password = "root";
		
		String SQL = "SELECT * from `empolyee`"
				+ " WHERE `E_DEPT` = ?";
		
		try {
			 connection=DriverManager.getConnection(url, user,password);
			statement =connection.prepareStatement(SQL);
			System.out.println("enter the department name :");
			String E_DEPT= scan.next();
			statement.setString(1, E_DEPT); 
			rest = statement.executeQuery();
			
			
			//display
			System.out.println(".........................................................................");
			
			while(((ResultSet) rest).next()) {
						
						int E_ID =  rest.getInt("E_ID");
						String E_NAME = rest.getString("E_NAME");
						String E_EMAIL = rest.getString("E_EMAIL");
						String E_DEPT1 = rest.getString("E_DEPT");
						int E_SALARY = rest.getInt("E_SALARY");
						
						
					//	System.out.println(E_ID +"  "+ E_NAME+"  "+ E_EMAIL+"  "+ E_DEPT+"  "+ E_SALARY);
						System.out.printf("|%-3d| %-13s| %-20s| %-9s| %d|\n", E_ID,E_NAME,E_EMAIL,E_DEPT,E_SALARY);
				
					}
			
			
			
			System.out.println("...........................................................................");
			
		
			statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
