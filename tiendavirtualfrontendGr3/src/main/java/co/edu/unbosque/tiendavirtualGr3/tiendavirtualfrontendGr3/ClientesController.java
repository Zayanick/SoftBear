///////////////////////////wwwwwwwwwwwwwwwwwwwwwww/wwwwwwww
package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.*;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*;


@Controller
public class ClientesController {
	
private ArrayList<ClientesVO> listaClientes;
private ArrayList<UsuarioVO> listaUsuarios;
private ArrayList<ProveedoresVO> listaProveedores;
private String fileLocation;
private String SHEET="archivo";
	
	@Autowired
	private ClienteDAO objEstDao;
	private UsuarioDAO objEstDaoo;
	private ProveedorDAO objEstDaooo;
	
	
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
	
	@PostMapping("/crearCliente")//crearCliente
	public String crearCliente(Model model, ClientesVO cliente) {

		objEstDao = new ClienteDAO();
		
		model.addAttribute("cliente", objEstDao.nuevoUsuario(cliente));
		consultarClientes();
		model.addAttribute("cliente", getListaClientes());

		return "Clientes";

			}


//////////////////////////////////////////////USUARIOS//////////////////////
	
	public void consultarUsuarios() {
		objEstDaoo = new UsuarioDAO();
		String json = objEstDaoo.listarUsuarios();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<UsuarioVO>>(){}.getType();
            Gson gson = new Gson();
            listaUsuarios = gson.fromJson(json, listType);
        }else {
        	listaUsuarios = new ArrayList<UsuarioVO>();
        }
	}

	public UsuarioVO guardarUsuario(UsuarioVO est) {
		objEstDaoo = new UsuarioDAO();
		return objEstDaoo.nuevoUsuario(est);
	}

	public ArrayList<UsuarioVO> getListaUsuarios() {
		return listaUsuarios;
	}


	public void setListaUsuarios(ArrayList<UsuarioVO> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model model, UsuarioVO usuario) {

		objEstDaoo = new UsuarioDAO();
		
		model.addAttribute("usuario", objEstDaoo.nuevoUsuario(usuario));
		consultarUsuarios();
		model.addAttribute("usuario", getListaUsuarios());

		return "Usuarios";

			}

	@GetMapping("/Menu")
	public String usuario(Model model) {
		consultarUsuarios();
		model.addAttribute("usuario", getListaUsuarios());
		//model.addAttribute("usuarios", clienteTienda.getUsuarios());
		return "Menu";
	}

	@PostMapping("/auth")
	public String auth(Model model, UsuarioVO usuario) {
		objEstDaoo =  new UsuarioDAO();
		UsuarioVO usr = objEstDaoo.auth(usuario);
		if(usr != null) {
		model.addAttribute("usuario", usr);
		return "Menu";
		
		}else {
		model.addAttribute("error", "Usuario o constraseña invalidos.");
		}
		return "auth";
	}
	
	@PostMapping("/borrarUsuario")
 	public String borrarUsuario(Model model, UsuarioVO usuario) {
 
 		UsuarioDAO dao = new UsuarioDAO();
 		
 		model.addAttribute("Usuario",  dao.borrarUsuario(usuario));
 		consultarUsuarios();
 		model.addAttribute("Usuarios", getListaUsuarios());		
 		return "redirect:/Usuarios.jsp";
 
}
	///////////////////////////////////////PROVEEDORES/////////////////
	public void consultarProveedores() {
		objEstDaooo = new ProveedorDAO();
		String json = objEstDaooo.listarProveedores();
		if(json  != null) {
            Type listType = new TypeToken<ArrayList<ProveedoresVO>>(){}.getType();
            Gson gson = new Gson();
            listaProveedores = gson.fromJson(json, listType);
        }else {
        	listaProveedores = new ArrayList<ProveedoresVO>();
        }
	}

	public ProveedoresVO guardarProveedor(ProveedoresVO est) {
		objEstDaooo = new ProveedorDAO();
		return objEstDaooo.nuevoProveedor(est);
	}

	public ArrayList<ProveedoresVO> getListaProveedores() {
		return listaProveedores;
	}


	public void setListaProveedores(ArrayList<ProveedoresVO> listaProveedores) {
		this.listaProveedores = listaProveedores;
	}
	
	@PostMapping("/crearProveedor")
	public String crearProveedor(Model model, ProveedoresVO proveedor) {

		objEstDaooo = new ProveedorDAO();
		
		model.addAttribute("proveedor", objEstDaooo.nuevoProveedor(proveedor));
		consultarProveedores();
		model.addAttribute("proveedor", getListaProveedores());

		return "Proveedores";

			}
	
	
	///////////////////////////////////////PRODUCTOS///////////////////
	
	@PostMapping("/uploadCSVFile")
	public String uploadFile(Model model, MultipartFile file) throws IOException{
		try {
			List<ProductoVO> misP = new ArrayList<ProductoVO>(); //Lista <ProductoVO>
			List<String[]> datos = CSVHelper.csvToTutorials(file.getInputStream()); //Lista arreglo de strings
			ProductoVO p;
			for(String[] s: datos) {
				StringTokenizer token = new StringTokenizer(s[0], ";");
				String[] tok = new String[6];
				int i = 0;
				while(token.hasMoreTokens()){
					tok[i] = token.nextToken();
					i++;
				}
				
				
		    	  p =  new ProductoVO(Integer.parseInt(tok[0]), Long.parseLong(tok[1]), Float.parseFloat(tok[2]), tok[3], Float.parseFloat(tok[4]), Float.parseFloat(tok[5]) );
		    	  misP.add(p);
				
				//p =  new ProductoVO(Integer.parseInt(tok[0]),i, tok[1], i, i, i);
		    	  //misP.add(p);
			}
			
		    ClienteDAO miDao =  new ClienteDAO();
		    miDao.borrarProductos();
		    for(ProductoVO prod: misP) {
		    	ProductoVO pRec = miDao.nuevoProducto(prod);
		    	if(pRec != null) {
		    		model.addAttribute("cargaArchivo", "Guardado");
		    	}
		    	else{
		    		model.addAttribute("errorCargaArchivo", "No se pudo guardar el producto");
		    		break;
		    	  }
		    }
		    //repository.saveAll(tutorials);
	        }
		catch (IOException e) {
	       throw new RuntimeException("fail to store csv data: " + e.getMessage());
	    }
   	    //model.addAttribute("message", "File:  has been uploaded successfully!");
        return "uploadFile";
    }

@GetMapping("/borrarProductos")
public void borrarProductos() {
	ClienteDAO miDao =  new ClienteDAO();
	miDao.borrarProductos();
	
}
	
	
}
