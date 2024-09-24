package service;

import java.util.List;

import entities.Hotel;

 
public interface HotelesService { 	
	
	Hotel findById(int idHotel);	
	List<Hotel> findByLocalizacion(String localizacion);
	List<String> findListaDestinos();

}