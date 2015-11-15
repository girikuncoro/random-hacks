package web;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import businessLayer.UserService;
import domain.User;

@Path("/user")
public class UserApi {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		UserService svc = new UserService();
		return svc.getUsers();

	}

	@GET
	@Path("/newUser")
	public String getNewUsers() {
		return "newUser";
	}
}
