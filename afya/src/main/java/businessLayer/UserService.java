package businessLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
import database.UserDatabaseConnector;
import domain.User;

public class UserService {
	
	public List<User> getUsers() {
		DatabaseConnector c = new DatabaseConnector();
		return c.getResultSet();
		
	}

	public List<User> searchUsers(String userName) {
		UserDatabaseConnector c = new UserDatabaseConnector();
		List<User> users = new ArrayList<User>();
		if(userName == null || userName.trim().isEmpty())
			return users;
		try {
			return c.searchUsers(userName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
