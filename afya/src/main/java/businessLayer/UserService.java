package businessLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnector;
import domain.User;

public class UserService {
	
	public List<User> getUsers() {
		DatabaseConnector c = new DatabaseConnector();
		return c.getResultSet();
		
	}
}
