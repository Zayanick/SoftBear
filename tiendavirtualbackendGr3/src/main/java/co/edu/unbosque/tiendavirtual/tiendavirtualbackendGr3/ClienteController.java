package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;
import java.util.List;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.*;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ClienteDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.ProveedoresDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;

@RestController
@RequestMapping
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
	
	@GetMapping("/editarrCliente/{cedula}")
	public String editarCliente(@PathVariable int cedula,  Model model ) {
		
		//Optional<ClienteDAO> clientes=  ClienteDAO.listaClientes();
		
		return "form";
	}
	
	@PostMapping("/registrarClientes")
	public Clientes registrarCliente(@RequestBody Clientes persona) 
	 {
		ClienteDAO dao=new ClienteDAO(); 
	    return dao.registrarCliente(persona);
	 }	
	
	@RequestMapping("/borrarCliente")
	public Clientes borrarCliente(@RequestBody Clientes ClienteDTO ) {
		ClienteDAO dao =  new ClienteDAO();
		
		return dao.borrarCliente(ClienteDTO);		
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
	
	@RequestMapping("/borrarUsuario")
	public Usuario borrarUsuario(@RequestBody Usuario UsuarioDTO ) {
		UsuarioDAO dao =  new UsuarioDAO();
		
		return dao.borrarUsuario(UsuarioDTO);		
	}
	
	
	/////////////////////////////////////////////PROVEEDORES/////////////////////////////////////////////////////////
	@RequestMapping("/listarProveedores")
	public ArrayList<Proveedores> listaProveedores() {
		ProveedoresDAO objDAO=new ProveedoresDAO(); 
			return objDAO.listaDeProveedores();
		
	}
	
	
	@PostMapping("/registrarProveedores")
	public Proveedores registrarProveedor(@RequestBody Proveedores persona) 
	 {
		ProveedoresDAO dao=new ProveedoresDAO(); 
	    return dao.registrarProveedor(persona);
	 }	
	
	@RequestMapping("/borrarProveedor")
	public Proveedores borrarProveedor(@RequestBody Proveedores ProveedoresDTO ) {
		ProveedoresDAO dao =  new ProveedoresDAO();
		
		return dao.borrarProveedor(ProveedoresDTO);		
	}
	
	/////////////////////////////////////////////PRODUCTOS///////////////////////////////////////////////////////////
	
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
	
	@RequestMapping("/listarVentas")
	public ArrayList<Ventas> listaVentas() {
		UsuarioDAO objDAO=new UsuarioDAO(); 
			return objDAO.listaDeVentas();
		
	}
	
}


 