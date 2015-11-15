package container;

import org.glassfish.jersey.server.ResourceConfig;

import web.UserApi;

public class AfyaMainContainer extends ResourceConfig {
	
	public AfyaMainContainer() {
		
		register(UserApi.class);
	}
	

}
