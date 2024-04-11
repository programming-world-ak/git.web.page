package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo2 {

	public static void main(String[] args) {
		
		
		
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String usre = "root";
		String password ="root";
		String SQL = "SELECT * from empolyee";
		
		
		try {
			Connection connection=DriverManager.getConnection(url, usre, password);
			Statement statment = connection.createStatement();
			ResultSet rest= statment.executeQuery(SQL);
			
			
			while(rest.next()) {
				
				int E_ID = rest.getInt("E_ID");
				String E_NAME = rest.getString("E_NAME");
				String E_EMAIL = rest.getString("E_EMAIL");
				String E_DEPT = rest.getString("E_DEPT");
				int E_SALARY = rest.getInt("E_SALARY");
				
				
				System.out.println(E_ID +"  "+ E_NAME+"  "+ E_EMAIL+"  "+ E_DEPT+"  "+ E_SALARY);
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
	}

}
