package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO.Usuarios;
import co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DAO.UsuarioDAO;
@RestController
public class UsuarioController {

	/**
	 * permite consultar la lista de Clientes
	 * @return
	 */
	@RequestMapping("/listarUsuarios")
	public ArrayList<Usuarios> listaDeUsuarios() {
		UsuarioDAO objDAO=new UsuarioDAO();
			return objDAO.listaDeUsuarios();
		
	}
	
	@PostMapping("/registrarEstudiante")
	public Usuarios registrarEstudiante(@RequestBody Usuarios persona) 
	 {
		UsuarioDAO dao=new UsuarioDAO(); 
	    return dao.registrarUsuario(persona);
	 }

	@PostMapping("/auth")
	public Usuarios auth(@RequestBody Usuarios usr) {
		UsuarioDAO dao =  new UsuarioDAO();
		return dao.consultarUsuario(usr);
	}

}
