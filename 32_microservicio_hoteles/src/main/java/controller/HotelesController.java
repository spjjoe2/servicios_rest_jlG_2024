package controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import entities.Hotel;
import service.HotelesService;

 

 


@CrossOrigin("*")
@RestController
public class HotelesController {

	HotelesService hotelesService;

	public HotelesController(HotelesService hotelesService) {
		super();
		this. hotelesService =  hotelesService;
	}
	
	@GetMapping(value="hotel/{identificador}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel datosHotelPorId(@PathVariable("identificador") int identificador){
		return hotelesService.findById(identificador);
	}
	

	@GetMapping(value="hoteles/{localizacion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hotel>> listaHotelesPorLocalizacion(@PathVariable("localizacion") String localizacion){
		try {
			List<Hotel> hoteles= hotelesService.findByLocalizacion(localizacion);
			return new ResponseEntity<>(hoteles,HttpStatus.OK);
		}catch(RuntimeException ex) {
			return new ResponseEntity<>(null,HttpStatus.SERVICE_UNAVAILABLE);
		}
		
	}
}


