package service;

import java.util.List;
import org.springframework.stereotype.Service; 
import dao.VuelosDao; 
import entities.Reserva;


@Service
public class VuelosServiceImpl implements VuelosService {	
	
	 
	VuelosDao vuelosDao;	
	
	public VuelosServiceImpl(VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}
	
	public Reserva findById(int idVuelo) {
		return vuelosDao.findById(idVuelo)
				.orElse(null); 
	};		
	public List<Reserva> findByDestinoYplazas(String destino,int plazas){ 
		return vuelosDao.findByDestinoYPlazas(destino, plazas); 
		
	};
	
	public boolean actualizarPlazas(int idVuelo,int plazas) {
		  Reserva vuelo =vuelosDao.findById(idVuelo).orElse(null);
		  if (vuelo != null){		  
			  if (vuelo.getPlazas()>=plazas) {
				  vuelo.setPlazas(vuelo.getPlazas()-plazas);
				  vuelosDao.save(vuelo);
				  return true;
			  }else {
				  return false;
			  }
		  }
		  return false;	
	};	
 
}
 	



 