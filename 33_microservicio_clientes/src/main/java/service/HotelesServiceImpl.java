package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.HotelesDao;
import entities.Hotel;


@Service
public class HotelesServiceImpl implements HotelesService {	
	
	 
	HotelesDao hotelesDao;
	
	
	public HotelesServiceImpl(HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}


	public Hotel findById(int idHotel) {
		return hotelesDao.findById(idHotel) //Optional<Hotel>			 
				.orElse(null); 		
	};	
	
	
	public List<Hotel> findByLocalizacion(String localizacion){
		return hotelesDao.findByLocalizacion(localizacion) 
				.stream() 	 
				.toList();		
	}
	
 
 
}


 