package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class demoinsert {

	private static Connection connection;
	private static PreparedStatement statement;
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		String SQL= "INSERT INTO `empolyee` (`E_ID`, `E_NAME`, `E_EMAIL`, `E_DEPT`, `E_SALARY`) VALUES (?,?,?,?,?)";

		
		try {
			 connection = DriverManager.getConnection(url, user, password);
			 
			 
			 demo3.display(connection, statement, null);
			
				 statement = connection.prepareStatement(SQL);
			 
				 
			 
			 do 
			 {
				 System.out.println("enter ID:");
				 int ID = scan.nextInt();
				 System.out.println("ENTER NAME:");
				 String NAME = scan.next();
				 System.out.println("ENTER EMAIL:");
				 String EMAIL= scan.next();
				 System.out.println("ENTER DEPT:");
				 String DEPT= scan.next();
				 System.out.println("ENTER SALARY:");
				 int SALARY= scan.nextInt();
				 
				 
				 statement.setInt(1, ID);
				 statement.setString(2, NAME);
				 statement.setString(3, EMAIL);
				 statement.setString(4, DEPT);
				 statement.setInt(5, SALARY);
				 
				 
				// int i = statement.executeUpdate();
				 statement.addBatch();
				System.out.println("doyou want enter more empolyees? (yes/no)"); 
				 
			 }
			 while(scan.next().equalsIgnoreCase("yes") );
			 int[] arr = statement.executeBatch();
			 
			 
			 System.out.println();
			 
			 
			 for(int i= 0;i< arr.length;i++) {
				 
				 
				 System.out.print(arr[i] +" ");
			 }
			 
			 
			 
			 System.out.println();
			 
			 demo3.display(connection, statement, null);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
  