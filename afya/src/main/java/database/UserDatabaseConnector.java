package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public User createNewUser(User user) {
		Connection conn;
		try {
			conn = getConnection();
			PreparedStatement prep = conn.prepareStatement("INSERT INTO User (userId,lastName,firstName,dob)"
					+ " Values(?,?,?,?)");
			prep.setInt(1, user.getUserId());
			prep.setString(2,user.getLastName());
			prep.setString(3,user.getFirstName());
			prep.setDate(4,new Date(user.getDob().getTime()));
			prep.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}// end FirstExample
