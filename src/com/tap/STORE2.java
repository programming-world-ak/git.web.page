package com.tap;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class STORE2 {

	private static Connection connection;
	private static CallableStatement statement;


	public static void main(String[] args) {
		
Scanner scan=new Scanner(System.in);
		
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		
		
		
		
		try {
			connection = DriverManager.getConnection(url, user, password);
			
			statement =connection.prepareCall("{call count_empolyee_SALARY(?)}");
			
			System.out.println("enter salary :  ");
			
			statement.setInt(1, scan.nextInt());
			
			statement.registerOutParameter(1, Types.INTEGER);
			
			statement.execute();
			
			int count = statement.getInt(1);
			System.out.println(count);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
