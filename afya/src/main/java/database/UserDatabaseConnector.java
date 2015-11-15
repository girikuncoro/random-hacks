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

public class UserDatabaseConnector {

	
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection(DatabaseConfig.DB_URL, DatabaseConfig.USER, DatabaseConfig.PASS);
		return conn;
	}
	
	private Statement prepareStatement(Connection conn) throws SQLException {
		return conn.createStatement();
	}
	
	
	public List<User> getResultSet() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement statement = prepareStatement(conn);
		String sql = "Select * from User ";
		ResultSet rs = statement.executeQuery(sql);
		List<User>  users = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setUserId(rs.getInt("userId"));
			u.setDob(rs.getDate("dob"));
			users.add(u);
			
		}
		conn.close();
		rs.close();
		statement.close();
		return users;
	}

	public List<User> searchUsers(String userName) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		Statement statement = prepareStatement(conn);
		String sql = "Select * from User where firstName like 'userName%' or lastName like 'userName%'";
		ResultSet rs = statement.executeQuery(sql);
		List<User>  users = new ArrayList<User>();
		while (rs.next()) {
			User u = new User();
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));
			u.setUserId(rs.getInt("userId"));
			u.setDob(rs.getDate("dob"));
			users.add(u);
			
		}
		conn.close();
		rs.close();
		statement.close();
		return users;
	}

}// end FirstExample
