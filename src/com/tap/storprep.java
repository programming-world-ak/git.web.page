package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;



public class storprep {

	private static Connection connection;
	private static CallableStatement statement;
	

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		
		
		
		
		
		
		try {
			connection =DriverManager.getConnection(url, user, password);
			
			statement =connection.prepareCall("{call  count_empolyee(?,?)}");
			
			System.err.println("enter dept : ");
			
			statement.setString(1, scan.next());
			statement.registerOutParameter(2, Types.INTEGER);
			
			statement.execute();
			int noofempolyees = statement.getInt(2);
			System.out.println(noofempolyees);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		

	}

}
