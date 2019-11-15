package com.max.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public interface CepService {

	@GET
	@Path("/ws/{cep}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findCep(@PathParam("cep") String cep);
	
}
