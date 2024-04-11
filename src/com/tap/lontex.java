package com.tap;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class lontex {

	private static Connection connection;
	private static PreparedStatement statement;
	private static FileReader fr;

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
	       String SQL="UPDATE `empolyee` SET `intro` = ? WHERE E_ID = ?";
	       String path ="C:\\Users\\akhilnani\\eclipse-workspace\\javapractice\\jdbca1\\images\\myintro.txt";
			
			String url ="jdbc:mysql://localhost:3306/jdbcclass";
			String user = "root";
			String password ="root";
			
			
			try {
				connection =DriverManager.getConnection(url, user, password);
				statement =connection.prepareStatement(SQL);
				
				System.out.println("enter E_ID : ");
				
				statement.setInt(2, scan.nextInt());
				
				 fr= new FileReader(path);
				 
				statement.setClob(1, fr);
				int i =statement.executeUpdate();
				System.out.println(i);
				
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
