package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//singleton design pattern
	static Connection conn;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}	catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static Connection makeConnection() throws SQLException{
		
		String connectionUrl = "jdbc:postgresql://localhost:5432/bankaccountproject";
		String userName = "postgres";
		String password = "troncat";
		if(conn == null) {
			conn = DriverManager.getConnection(connectionUrl, userName, password);
		}
		return conn;
	}

}
