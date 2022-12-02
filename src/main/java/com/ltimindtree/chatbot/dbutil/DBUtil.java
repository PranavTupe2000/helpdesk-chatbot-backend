package com.ltimindtree.chatbot.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if(connection != null) {
			return connection;
		}else {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/chatbot";
			String username = "root";
			String password = "iamroot987456321";
			
			Class.forName(driver);
			
			connection = DriverManager.getConnection(url,username,password);
		}
		
		return connection;
	}
}
