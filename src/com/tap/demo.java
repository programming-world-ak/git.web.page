package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo {

	public static void main(String[] args) {
		
		
	    String url= "jdbc:mysql://localhost:3306/jdbcclass";
	    String user="root";
	    String password="root";
	    
	    
	    
		try {
			Connection connectin=DriverManager.getConnection(url, user, password);
			System.out.println("succefully connected to database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
