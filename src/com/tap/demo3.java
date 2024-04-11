package com.tap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class demo3 {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet rest =null;
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcclass";
		String user = "root";
		String password="root";
		
		
		try {
		    connection =DriverManager.getConnection(url, user, password);
		    
		    display(connection,statement,rest);

			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			colse(connection, statement, rest);
			
		}


	}

	public static void display(Connection connection, Statement statement, ResultSet rest) throws SQLException {
		
		String SQL="SELECT* from empolyee";
		
		
		 statement = connection.createStatement();
		 rest =statement.executeQuery(SQL);
		
		
while(rest.next()) {
			
			int E_ID = rest.getInt("E_ID");
			String E_NAME = rest.getString("E_NAME");
			String E_EMAIL = rest.getString("E_EMAIL");
			String E_DEPT = rest.getString("E_DEPT");
			int E_SALARY = rest.getInt("E_SALARY");
			
			
		//	System.out.println(E_ID +"  "+ E_NAME+"  "+ E_EMAIL+"  "+ E_DEPT+"  "+ E_SALARY);//
			System.out.printf("|%-3d| %-13s| %-20s| %-9s| %d|\n", E_ID,E_NAME,E_EMAIL,E_DEPT,E_SALARY);
		}
		
	}

	private static void colse(Connection connection, Statement statement, ResultSet rest) {
		//alt+shift+m=creat a method
		try {
			if(rest!=null) {
			rest.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		try {
			if(statement !=null) {
			statement.close();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		try {
			if(connection != null) {
				connection.close();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
