package service;

 
import java.util.List;

import entities.Vuelo;

 
public interface VuelosService { 	
	
	Vuelo findById(int idVuelo);		
	List<Vuelo> findByDestinoYplazas(String destino,int plazas);
	boolean actualizarPlazas(int idVuelo,int plazas);	

}