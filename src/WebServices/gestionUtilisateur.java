package WebServices;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import troc.utilisateur;

@Path("/auth")
@ApplicationPath("/rest")
public class gestionUtilisateur {
	
	

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void login(utilisateur loginInfo, @Context HttpServletRequest request) throws LoginException, ServletException {

	    request.getSession();
	    request.login(loginInfo.getNom(), loginInfo.getPassword());
}
}
