package com.narabel.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.narabel.dao.PersonaDaoImpl;
import com.narabel.entity.Persona;

@Path("/personas")
public class HelloWorldRest  implements ExceptionMapper<Exception>{
	
	private static List<String> lista = new ArrayList();
	
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Persona> listarPersonas() {
		return new PersonaDaoImpl().findAll();
	}
	
//	@GET
//	@Path("{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response getCustomer(@PathParam("id") int id) {
//		return Response.ok("Retorno: "+id).build();
//	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("{id}") // hace referencia a /personas/{id}
	public Persona encontrarPersonaPorId(@PathParam("id") int id) {
		List<Persona> personas = new PersonaDaoImpl().findAll();
		try {
			return personas.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

//	@GET
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	public Response sayHello() {
//		lista.add("Nelson");
//		lista.add("Arabel");
//		GenericEntity<List<String>> entities = new GenericEntity<List<String>>(lista){};
//		return Response.ok(lista.toString()).build();
//	}

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response agregarPersona(Object persona) {
		try {
			
			return Response.ok().entity(persona).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Override
	public Response toResponse(Exception exception) {
		 exception.printStackTrace();
	     return Response.serverError().entity(exception.getMessage()).build();
	}

	/*
	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response agregarPersona(Persona persona) {
		try {
			personaService.registrarPersona(persona);
			return Response.ok().entity(persona).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	*/

	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductos() {
		GenericEntity<List<Producto>> entities = new GenericEntity<List<Producto>>(lista){};
		return Response.ok(entities).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@PathParam("id") int id) {
		return Response.ok("Retorno: "+id).build();
	}
*/
}
