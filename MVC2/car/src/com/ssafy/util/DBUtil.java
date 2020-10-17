package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/javaadd?serverTimezone=UTC";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String ID = "ssafy";
	private static final String PW = "1234";
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, ID, PW);
	}
	
	public static void close(AutoCloseable c) {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
