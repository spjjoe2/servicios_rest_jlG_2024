package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/pruebas")
public class SaludoController {
	@GET
	@Path("/saludar")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludo() {
		return "Bienvenido a mi servicio Rest";
	}

 
	@GET
	@Path("/saludar/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSaludoPersonal(@PathParam("name") String nombre) {
		return "Bienvenido a mi servicio Rest sr/sra." + nombre;
	}
	
	@GET
	@Path("/info")
	@Produces(MediaType.TEXT_PLAIN)
	public String getinfo(@QueryParam("name") String nombre,@QueryParam("age") int edad) {
		return "Te llamas" + nombre +" y tienes edad "+ edad;
	}


}
