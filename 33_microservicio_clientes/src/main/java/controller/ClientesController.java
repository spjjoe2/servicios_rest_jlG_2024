package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.Cliente;
import service.ClientesService;

 

@CrossOrigin("*")
@RestController
public class ClientesController {

	ClientesService clientesService;

	public ClientesController(ClientesService hotelesService) {
		super();
		this.clientesService =  clientesService;
	}
	
	@GetMapping(value="cliente/{usuario}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente datosClientelPorId(@PathVariable("usuario") String usuario){
		return clientesService.findById(usuario);
	}
	
	@GetMapping(value="datosCliente/{usuario}/{password}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Cliente datosClientelPorUsrPwd(@PathVariable("usuario") String usuario,@PathVariable("password") String password){
		return clientesService.findByUserYPwd(usuario,password);
	}
	
		
	@PostMapping(value="altaCliente",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCliente(@PathVariable("cliente") Cliente cliente){
		 clientesService.altaCliente(cliente); 
		
	}
}


