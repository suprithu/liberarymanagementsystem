package com.cruds.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	static
	 {
		 try 
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		 catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
	 }




public static Connection getConnection()
{
Connection conn = null;
try 
{
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","sabarehan");
} catch (SQLException e) {
e.printStackTrace();
System.out.println("Unable to connect to database");
}
//System.out.println("Connection successful");
return conn;
}}