package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class transaction {

	
	private static Connection connection;
	private static PreparedStatement statement;
	static final String SQL =" UPDATE `empolyee` SET `E_SALARY` =`E_SALARY` + ? WHERE `E_NAME` = ?";
	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		
		
		try {
			connection =DriverManager.getConnection(url, user, password);
			
			 demo3.display(connection, statement, null);
			
			 
			 connection.setAutoCommit(false);
			 Transaction();
			
			 demo3.display(connection, statement, null);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	 static void Transaction() throws SQLException  {
		
		System.out.println("enter the seder name :");
		String sender = scan.next();
		
		System.out.println("enter the recever name :");
		String recever = scan.next();
		
		System.out.println("enter the amount :");
		int amount = scan.nextInt();	
		
		int i = UpdateSalary (sender, -amount);
		int j = UpdateSalary (recever, amount);
		
		
		if (isconfirm(i,j)) {
			System.out.println("transaction successfull...");
			connection.commit();
			
			
		} else {
			
			System.out.println("transaction failed...");
			connection.rollback();

		}
		
	}

	 static int  UpdateSalary(String user, int amount) throws SQLException {
		 

			statement= connection.prepareStatement(SQL);
			statement.setInt(1, amount);
			statement.setString(2, user);
			
			int i =statement.executeUpdate();
		 
		 
		 
		 
	
		return i;
	}

	 static boolean isconfirm(int i, int j) {
		 System.out.println("do you want confirm the transction (yes/no)");
		 String choice = scan.next();
		
		return choice.equalsIgnoreCase("yes") && i==1 && j==1;
	}


}

