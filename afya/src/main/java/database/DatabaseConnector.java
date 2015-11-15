package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.User;

public class DatabaseConnector {

	public List<User> getResultSet() {
		Connection conn = null;
		Statement stmt = null;
		List<User>  users = new ArrayList<User>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "Select * from User";
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				User u = new User();
				u.setFirstName(rs.getString("firstName"));
				u.setLastName(rs.getString("lastName"));
				u.setUserId(rs.getInt("userId"));
				u.setDob(rs.getDate("dob"));
				users.add(u);
				
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
		System.out.println("Goodbye!");
		return users;
	}

	
}// end FirstExample
