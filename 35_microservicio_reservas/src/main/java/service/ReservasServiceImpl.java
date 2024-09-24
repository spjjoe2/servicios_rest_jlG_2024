package service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import dao.ReservasDao;
import entities.Hotel;
import entities.Reserva;
import entities.Vuelo;
 


@Service
public class ReservasServiceImpl implements ReservasService {	
	
 	
	String urlHoteles="http://localhost:8000/hoteles/";
	String urlVuelos="http://localhost:8700/vuelos/";
	RestClient restClient;
 
	ReservasDao reservasDao;
	Reserva reserva;
	
	public ReservasServiceImpl(RestClient restClient, ReservasDao reservasDao) {
		super();
		this.restClient = restClient;
		this.reservasDao = reservasDao;
	}


	public Vuelo recuperarVuelo(int idVuelo) {
		return  restClient
		.get()
		.uri(urlVuelos+"vuelo/{idVuelo}") 
		.retrieve()		
		.body(Vuelo.class);//Vuelo		
	}
	
	
	public Hotel recuperarHotel(int idHotel) {
		return  restClient
		.get()
		.uri(urlHoteles+"hotel/{identificador}")
		.retrieve()	
		.body(Hotel.class);		
	}
	
	public Reserva prepararReserva(String usuario, int idVuelo, int idHotel, int numPlazas) {
		
		return  new Reserva(0,usuario,recuperarVuelo(idVuelo),recuperarHotel(idHotel),recuperarVuelo(idVuelo).getPrecio()*numPlazas);		
		
	}
 
	
	public void altaReserva(ReservaDto reserva,int plazas) { 
		 		   
		   reservasDao.save(reserva);
	};	

}

 
 	



 