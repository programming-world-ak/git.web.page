package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class demoupdate {
	private static Statement statement;
	private static Connection connection;

	public static void main (String[]args) {
		
		

		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password = "root";
		String SQL = "UPDATE`empolyee`"
				+ "SET`E_salary` = `E_salary`+ 5000 "
				+ "WHERE `E_DEPT` = 'hr'";
		
		try {
			 connection = DriverManager.getConnection(url, user, password);
			demo3.display(connection,statement,null);
			
			Statement statement=connection.createStatement();
			
			int i=statement.executeUpdate(SQL);
			
			System.out.println(i);
			
			System.out.println();
			demo3.display(connection,statement,null);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
