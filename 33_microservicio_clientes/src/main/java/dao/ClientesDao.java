package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entities.Cliente;

public interface ClientesDao extends JpaRepository<Cliente,String>{	 
	
	@Query("select c from Cliente c where c.usuario=?1 and c.password=?2")
	Cliente findByUsrYPwd(String ususario, String password);	
	Cliente findByUsuario(String usuario);
	
	  
}
