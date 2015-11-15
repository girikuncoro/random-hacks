package web;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import businessLayer.UserService;
import domain.User;

@Path("/user")
public class UserApi {
	
	@GET()
	@Path("/allUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getALLUsers() {
		UserService svc = new UserService();
		return svc.getUsers();

	}

	@GET()
	@Path("/allUsers/{userQuery}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUser(@PathParam("userQuery") String userName) {
		UserService svc = new UserService();
		return svc.searchUsers(userName);

	}

	@GET
	@Path("/newUser")
	public String getNewUsers() {
		return "newUser";
	}
}
