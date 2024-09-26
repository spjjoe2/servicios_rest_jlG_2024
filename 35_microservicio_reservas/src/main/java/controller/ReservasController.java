package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import model.ReservaDto;
import service.ReservasService;

 

@CrossOrigin("*")
@RestController
public class ReservasController {

	ReservasService reservasService;
	
	
	public ReservasController(ReservasService reservasService) {
		super();
		this.reservasService = reservasService;
	}


	@PostMapping(value="altaReserva", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> altaReserva(@RequestBody ReservaDto reservaDto, @RequestParam("plazas") int plazas) { // Le indicamos que no hay tipo de devolución
		//System.out.println("Entra en reservaController");
		//System.out.println(reserva.getNombre());
		if(reservasService.altaReserva(reservaDto, plazas)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
 
}

 

 

