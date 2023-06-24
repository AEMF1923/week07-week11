package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import projects.exception.DbException;

public class DbConnection {
	private static final String SCHEMA = "projects";
	private static final String USER = "projects";
	private static final String PASSWORD = "projects";
	private static final String HOST = "localhost";
	private static final int PORT = 3306;

	//making a method that is called Connection and it uses a method called getConnection; it seems that getConnection is a built 
	//java method that we are using. This is a driver that connects to the database
	public static Connection getConnection() {
		String uri = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s",HOST,PORT,SCHEMA,USER,PASSWORD);
		
		try {
			Connection conn = DriverManager.getConnection(uri);
			System.out.println("Connection to schema " + SCHEMA + " is successful."); //Where you place the sysout print statement is important
			return conn;
		} catch (SQLException e) {
			System.out.println("Unable to get connection at " + uri);
			throw new DbException("Unable to get connection at \" + uri");
		}
		
	}
}
