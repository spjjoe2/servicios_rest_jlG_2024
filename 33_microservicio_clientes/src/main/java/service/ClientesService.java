package service;

import java.util.List;

import entities.Cliente;

 
public interface ClientesService { 	
	
	Cliente findById(String usuario);		
	Cliente findByUserYPwd(String ususrio,String password);
	boolean altaCliente(Cliente cliente);
	
	

}