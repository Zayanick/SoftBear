package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.*;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ClienteDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;

@RestController
public class ClienteController {
	/**
	 * permite consultar la lista de Usuarios
	 * @return
	*/
//////////////////////////////////////////////////////////////////////////CLIENTES///////////////////////////////	
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
//////////////////////////////////////////////////////////////////////////USUARIOS/////////////////////////////////////	
	
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuario> listaUsuarios() {
		UsuarioDAO objDAO=new UsuarioDAO(); 
			return objDAO.listaDeUsuarios();
		
	}
	 
	@PostMapping("/registrarUsuario")
	public Usuario registrarUsuario(@RequestBody Usuario persona) 
	 {
		UsuarioDAO dao=new UsuarioDAO(); 
	    return dao.registrarUsuario(persona);
	 }

	@PostMapping("/auth")
	public Usuario auth(@RequestBody Usuario usr) {
		UsuarioDAO dao =  new UsuarioDAO();
		return dao.consultarUsuario(usr);
	}
	
	@GetMapping("/borrarProductos")
	public void borrarProductos() {
		ClienteDAO dao =  new ClienteDAO();
		
		dao.SafeUpdate();
		dao.eliminarProductos();
		dao.SafeUpdate();
		
	}
	
	@PutMapping("/registrarProducto")
	public Producto registrarProducto(@RequestBody Producto p) {
		ClienteDAO dao =  new ClienteDAO();
		return dao.registrarProducto(p);	
	}
	
	
}


 