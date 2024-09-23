package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 
import entities.Vuelo;
import service.VuelosService;

 

@CrossOrigin("*")
@RestController
public class VuelosController {

	VuelosService vuelosService;

	public VuelosController(VuelosService vuelosService) {
		super();
		this.vuelosService =  vuelosService;
	}
	
	@GetMapping(value="vuelo/{idVuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Vuelo datosVuelolPorId(@PathVariable("idVuelo") int idVuelo){	 
		return vuelosService.findById(idVuelo);
	}
	
	@GetMapping(value="vuelos/{destino}/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listaVuelos(@PathVariable("destino") String destino,@PathVariable("plazas") int plazas){
		return vuelosService.findByDestinoYplazas(destino,plazas);
		 
	}
	
		
	@PostMapping(value="actualizarPlazas/{idVuelo}/{plazas}")
	public ResponseEntity<Void> actualizarPlazas(@PathVariable("idVuelo") int idVuelo,@PathVariable("plazas") int plazas ){
		if(vuelosService.actualizarPlazas(idVuelo,plazas)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	
 
}

 

 

