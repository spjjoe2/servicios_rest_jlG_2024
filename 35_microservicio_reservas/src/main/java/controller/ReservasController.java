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

import entities.Reserva;
import service.ReservasService;

 

@CrossOrigin("*")
@RestController
public class ReservasController {

	ReservasService reservasService; 
	
		
	@PostMapping(value="altaReserva",consumes=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Void> altaReserva(@PathVariable("destino") String destino,@PathVariable("idHotel") String idHotel,@PathVariable("personas") int personas,@PathVariable("idVuelo") int idVuelo){
		
		if(reservasService.altaReserva(String destino,String nombreHotel,int personas, int idVuelo)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		
	}
	
	@PostMapping(value="altaReserva", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaReserva(@RequestBody ReservaDto reserva, @RequestParam int plazas) { // Le indicamos que no hay tipo de devolución
		//System.out.println("Entra en reservaController");
		//System.out.println(reserva.getNombre());
		if(service.altaReserva(reserva, plazas)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

}

 

 

