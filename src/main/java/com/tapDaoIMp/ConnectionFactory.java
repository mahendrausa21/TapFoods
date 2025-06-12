package com.tapDaoIMp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tapfoods", "root", "m@hendr@");
		
		return con;
	}
	
	
}
