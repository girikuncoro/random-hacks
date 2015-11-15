package businessLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.UserDatabaseConnector;
import domain.User;

public class UserService {
	
	private UserDatabaseConnector conn = new UserDatabaseConnector();
	
	public List<User> getUsers() {
		
		try {
			return conn.getResultSet();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<User> searchUsers(String userName) {
	
		List<User> users = new ArrayList<User>();
		if(userName == null || userName.trim().isEmpty())
			return users;
		try {
			return conn.searchUsers(userName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public User createNewUser(User user) {
		return conn.createNewUser(user);
	}
}
