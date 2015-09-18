package com.technia.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSQLLite {

	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:src/main/resources/com/technia/db/sales_database.db");
			System.out.println("Opened database successfully");
			Statement statement = c.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from store");
			while (rs.next()) {
				System.out.println("id: " + rs.getString("id"));
				System.out.println("country: " + rs.getString("country"));
			}
		} catch (ClassNotFoundException e) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
			e.printStackTrace();
		} catch (SQLException e) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		


	}

}
