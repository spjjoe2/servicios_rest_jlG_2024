package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Reserva;

public interface VuelosDao extends JpaRepository<Reserva,Integer>{	 
	
	@Query("select v from Vuelo v where v.destino=?1 and v.plazas>=?2")
	List<Reserva> findByDestinoYPlazas(String destino, int plazas); 
	
	  
}
