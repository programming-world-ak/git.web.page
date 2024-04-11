package com.tap;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class imgdemo {

	private static Connection connection;
	private static PreparedStatement statement;
	private static FileInputStream Fis ;


	public static void main(String[] args) {
		
Scanner scan=new Scanner(System.in);
       String SQL="UPDATE `empolyee` SET `DP` = ? WHERE E_ID = ?";
       String path ="C:\\Users\\akhilnani\\eclipse-workspace\\javapractice\\jdbca1\\images\\narutorender25mc9.png";
		
		String url ="jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password ="root";
		
		
		try {
			connection =DriverManager.getConnection(url, user, password);
			statement =connection.prepareStatement(SQL);
			
			System.out.println("enter E_ID : ");
			
			statement.setInt(2, scan.nextInt());
			
			 Fis = new FileInputStream(path);
			 
			statement.setBinaryStream(1, Fis);
			int i =statement.executeUpdate();
			System.out.println(i);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}catch (  FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
