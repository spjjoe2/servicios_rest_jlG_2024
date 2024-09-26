package service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import dao.ReservasDao;
import entities.Hotel;
import entities.Reserva;
import entities.Vuelo;
import model.ReservaDto;
 


@Service
public class ReservasServiceImpl implements ReservasService {	
	
 	
	String urlHoteles="http://localhost:8000/hoteles/";
	String urlVuelos="http://localhost:8700/vuelos/";
	RestClient restClient; 
	ReservasDao reservasDao;
	ReservaDto reservaDto;
	 
	
	 
	
	public ReservasServiceImpl(RestClient restClient, ReservasDao reservasDao) {
		super();
		this.restClient = restClient;
		this.reservasDao = reservasDao;	 
	}


	public Vuelo recuperarVuelo(int idVuelo) {
		 
		return  restClient
		.get()
		.uri(urlVuelos+"vuelo/idVuelo") 
		.retrieve()		
		.body(Vuelo.class);//Vuelo		
	}
	
	
	public Hotel recuperarHotel(int idHotel) {
		return  restClient
		.get()
		.uri(urlHoteles+"hotel/idHotel")
		.retrieve()	
		.body(Hotel.class);		
	}
	

	
	public boolean altaReserva(ReservaDto reservaDto,int plazas) { 
		   double precioReserva =recuperarVuelo(reservaDto.getVueloDto().getIdVuelo()).getPrecio()*plazas;
		   
		   Reserva reserva = new Reserva(0,reservaDto.getUsuario(),recuperarVuelo(reservaDto.getVueloDto().getIdVuelo()),recuperarHotel(reservaDto.getHotelDto().getIdHotel()),precioReserva);
		   if(plazas>0) {
		   		reservasDao.save(reserva);
		   		return true;
		   }
		   return false;
		   
	};	

}

 
 	



 