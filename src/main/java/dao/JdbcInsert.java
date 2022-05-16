package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {

	public static void main(String[] args) {
		//step 1 - Load the driver class into the memory
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded...");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//step 2 - establish the connection to the database server
		try {
			//step 2 - establish the connection to the database server
			//connectionURL has the protocol, ipaddress, port
			String connectionUrl = "jdbc:postgres://localhost:5432/bankaccountproject";
			String userName = "postgres";
			String password = "troncat";
			Connection conn = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection Established...");
			
			//step 3 - create a statement and execute it
			Statement stmt = conn.createStatement(); 
			//String query = "INSERT INTO"
			//step 4 - handle the exception
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
