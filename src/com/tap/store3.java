package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class store3 {

	private static Connection connection;
	private static CallableStatement statement;
	private static ResultSet resultSet;
	
	

	public static void main(String[] args) {
		 
		
		
		
Scanner scan=new Scanner(System.in);
		
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		
		
		
		try {
			connection =DriverManager.getConnection(url, user, password);
			 statement =connection.prepareCall("{call GET_empolyee(?)}");
			 
			 
			 
			 
			 System.err.println("enter salary: ");
			
			 statement.setInt(1, scan.nextInt());
			 statement.execute();
			ResultSet rest = statement.getResultSet();
			//display
			
			System.err.println("..........................................................");
			while(rest.next()) {
				
				int E_ID = rest.getInt("E_ID");
				String E_NAME = rest.getString("E_NAME");
				String E_EMAIL = rest.getString("E_EMAIL");
				String E_DEPT = rest.getString("E_DEPT");
				int E_SALARY = rest.getInt("E_SALARY");
				
				
			//	System.out.println(E_ID +"  "+ E_NAME+"  "+ E_EMAIL+"  "+ E_DEPT+"  "+ E_SALARY);//
				System.out.printf("|%-3d| %-13s| %-20s| %-9s| %d|\n", E_ID,E_NAME,E_EMAIL,E_DEPT,E_SALARY);
			}
			System.out.println("..........................................................");
			//statement =connection.preparecall("{call GET_empolyee(?)}");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
