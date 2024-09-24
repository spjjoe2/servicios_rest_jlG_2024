package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Hotel;

public interface HotelesDao extends JpaRepository<Hotel,Integer>{	 
	
	List<Hotel> findByLocalizacion(String localizacion);
	
	
	@Query("select distinct(h.localizacion)  from Hotel h")	 
	List<String> findListaDestinos();
}
