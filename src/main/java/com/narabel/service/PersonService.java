package com.narabel.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.narabel.dao.PersonDaoImpl;
import com.narabel.entity.Person;

@Path("/person")
public class PersonService  implements  ExceptionMapper<Exception>{
	
	private static List<String> lista = new ArrayList();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listar() {
		GenericEntity<List<Person>> entities = new GenericEntity<List<Person>>(new PersonDaoImpl().findAll()){};
		return Response.ok(entities).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Response obtenerPorId(@PathParam("id") int id) {
		List<Person> personas = new PersonDaoImpl().findAll();
		try {
			return Response.ok(personas.get(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response nueva(Person persona) {
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
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findAll() {
		GenericEntity<List<Person>> entities = new GenericEntity<List<Person>>(personaDao.findAll()){};
		return Response.ok(entities).build();
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("{id}")
	public Response findById(@PathParam("id") int id) {
		List<Person> personas = new PersonDaoImpl().findAll();
		try {
			return Response.ok(personas.get(id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

*/

}
