package service;

 
import java.util.List;

import entities.Reserva;

 
public interface VuelosService { 	
	
	Reserva findById(int idVuelo);		
	List<Reserva> findByDestinoYplazas(String destino,int plazas);
	boolean actualizarPlazas(int idVuelo,int plazas);	

}