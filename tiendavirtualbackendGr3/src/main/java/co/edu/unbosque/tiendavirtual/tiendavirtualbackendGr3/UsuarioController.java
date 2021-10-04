package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Estudiante;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuario;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.EstudianteDAO;
import co.edu.unbosquetiendavirtual.tiendavirtualbackendGr3.DAO.UsuariosDAO;

@RestController
public class UsuarioController {
	
	
	/**
	 * permite consultar la lista de Usuarios
	 * @return
	*/
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuario> listaDeUsuarios() {
		UsuariosDAO objDAO=new UsuariosDAO(); 
			return objDAO.listaDeUsuarios();
		
	}
	 

	@PostMapping("/registrarUsuario")
	public Usuario registrarUsuario(@RequestBody Usuario persona) 
	 {
		UsuariosDAO dao=new UsuariosDAO(); 
	    return dao.registrarUsuario(persona);
	 }

	@PostMapping("/auth")
	public Usuario auth(@RequestBody Usuario usr) {
		UsuariosDAO dao =  new UsuariosDAO();
		return dao.consultarUsuario(usr);
	}
	
	
}


 