package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.*;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ClienteDAO;

@RestController
public class ClienteController {
	
	
	/**
	 * permite consultar la lista de Usuarios
	 * @return
	*/
	@RequestMapping("/listarClientes")
	public ArrayList<Clientes> listaClientes() {
		ClienteDAO objDAO=new ClienteDAO(); 
			return objDAO.listaDeClientes();
		
	}
	 

	@PostMapping("/registrarClientes")
	public Clientes registrarCliente(@RequestBody Clientes persona) 
	 {
		ClienteDAO dao=new ClienteDAO(); 
	    return dao.registrarCliente(persona);
	 }

	@PostMapping("/auth")
	public Usuario auth(@RequestBody Usuario usr) {
		ClienteDAO dao =  new ClienteDAO();
		return dao.consultarUsuario(usr);
	}
	
}


 