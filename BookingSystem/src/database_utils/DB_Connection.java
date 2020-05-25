package database_utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB_Connection {
	
	private static String userName = "user";
	private static String passWord = "password";
	private static String conn = "jdbc:mysql://localhost/traveling?useSSL=false";
	// aware that useSSL is set to false now. not very safe (but it doesn't matter)
	
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(conn, userName, passWord);  // URL, user, password
	}
	
	public static void setUserName(String userName, String passWord) {
		DB_Connection.userName = userName.trim();
		DB_Connection.passWord = passWord;
	}
	
	public static void setConnectionString(String Conn) {
		DB_Connection.conn = Conn;
	}
		
}
