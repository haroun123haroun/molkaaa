package WebServices;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import service.gestiontroc;
import troc.article;

@Path("article")
public class restarticle {

@EJB
	private gestiontroc gestiontrocRemote;
	        @GET 
			@Produces(MediaType.APPLICATION_JSON)
			public List <article> getAnnonces()
			{
			List<article> listOfAnnonces=gestiontrocRemote.findAllarticle();
			

			return listOfAnnonces;
			
			}
			@GET
			@Produces (MediaType.APPLICATION_JSON)
			@Path ("{id}")
			public article getannoncesById(@PathParam("id")int id)
			{
			return gestiontrocRemote.findArticleById(id);
				//return  Response.status(Status.ACCEPTED).entity("msg").build();
			}

//
//
//			
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON )
	public Response addarticle( article article){
	 gestiontrocRemote.addarticle(article);
	 return Response.status(Status.ACCEPTED).entity("article a été ajouté avec sucssé !!").build();
	}

	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public void updatearticle(article article)
	{
	 gestiontrocRemote.updatearticle(article);
	 
	 //return Response.status(Status.ACCEPTED).entity("article a mise a jour avec sucssé !!").build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void deletearticle(article article)
	{
		gestiontrocRemote.deletearticle(article);

	}
	@DELETE
	@Path ("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deletearticleById(@PathParam("id")int id)
	{
		gestiontrocRemote.deleteArticleById(id);

	}
	}
	
