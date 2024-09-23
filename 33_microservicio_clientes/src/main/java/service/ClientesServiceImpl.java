package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dao.ClientesDao;
import entities.Cliente;


@Service
public class ClientesServiceImpl implements ClientesService {	
	
	 
	ClientesDao clientesDao;
	
	
	public ClientesServiceImpl(ClientesDao clientesDao) {
		super();
		this.clientesDao = clientesDao;
	}


	public Cliente findById(String usuario) {
		return clientesDao.findById(usuario)
				.orElse(null); 				 		
	}		
	
	 	
	public Cliente findByUserYPwd(String ususrio,String password) {
		return clientesDao.findByUsrYPwd(ususrio, password);
	} 
	
	
	public boolean altaCliente(Cliente cliente) {
		 
		
		if(clientesDao.findById(cliente.getUsuario()).isEmpty())  {
			clientesDao.save(cliente);
			return true;
		}
		return false;
	}
 
}


 