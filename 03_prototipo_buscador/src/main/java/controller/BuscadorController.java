package controller;


import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import service.BuscadorService;


@Path("/buscador")
public class BuscadorController {
	 BuscadorService buscadorService= new BuscadorService(); 
	 
	@GET
	@Path("/buscar/{tematica}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> fichaProducto(@PathParam("tematica") String tematica){
	 
		return  buscadorService.resultadoBusqueda(tematica);
	}
	
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alta(Resultado resultado) {
		buscadorService.alta(resultado);
	}
	
	
	@DELETE 
	@Path("/eliminar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> eliminar(@QueryParam("url") String url) {		
		return buscadorService.eliminar(url);
		
	}
 
}
 
 