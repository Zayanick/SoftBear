///////////////////////////wwwwwwwwwwwwwwwwwwwwwww/wwwwwwww
package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3;

import java.lang.reflect.Type;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.*;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*;


@Controller
public class ClientesController {
	
private ArrayList<ClientesVO> listaClientes;
	
	@Autowired
	private ClienteDAO objEstDao;
	
	
	
	public void consultarClientes() {
		objEstDao = new ClienteDAO();
		String json = objEstDao.listarUsuarios();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ClientesVO>>(){}.getType();
            Gson gson = new Gson();
            listaClientes = gson.fromJson(json, listType);
        }else {
        	listaClientes = new ArrayList<ClientesVO>();
        }
	}

	public ClientesVO guardarCliente(ClientesVO est) {
		objEstDao = new ClienteDAO();
		return objEstDao.nuevoUsuario(est);
	}

	public ArrayList<ClientesVO> getListaClientes() {
		return listaClientes;
	}


	public void setListaClientes(ArrayList<ClientesVO> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	@PostMapping("/crearCliente")
	public String crearCliente(Model model, ClientesVO cliente) {

		objEstDao = new ClienteDAO();
		
		model.addAttribute("cliente", objEstDao.nuevoUsuario(cliente));
		consultarClientes();
		model.addAttribute("cliente", getListaClientes());

		return "crearCliente";

			}

	@GetMapping("/crearCliente")
	public String cliente(Model model) {
		consultarClientes();
		model.addAttribute("clientes", getListaClientes());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "crearCliente";
	}

	@PostMapping("/auth")
	public String auth(Model model, UsuarioVO usuario) {
		objEstDao =  new ClienteDAO();
		UsuarioVO usr = objEstDao.auth(usuario);
		if(usr != null) {
		model.addAttribute("usuario", usr);
		}else {
		model.addAttribute("error", "Usuario o constraseña invalidos.");
		}
		return "auth";
	}
}
