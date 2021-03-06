package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ClientesVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;

public class UsuarioDAO {
private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;

	
public String listarUsuarios() {
		
	try {

        URL url = new URL(URL+"/listarUsuarios");//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String json = br.readLine();
        conn.disconnect();
        return json;
    } catch (Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }
	return null;
}


public UsuarioVO nuevoUsuario(UsuarioVO usuarioDto) {

try {
	WebClient webClient = WebClient.create(URL);
	UsuarioVO  objCliente = null;
	Mono<UsuarioVO > response = webClient.post().uri(URL + "/registrarUsuario")
			.body(Mono.just(usuarioDto), UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);

	objCliente = response.block();
	return objCliente;

} catch (WebClientResponseException e) {
	e.getMessage();
	System.out.println("---->" + e.getMessage());
	return null;
}

}

public UsuarioVO auth(UsuarioVO usr) {
WebClient webClient =  WebClient.create(URL);
UsuarioVO objUsuario = null;

Mono<UsuarioVO> response = webClient.post().uri(URL+"/auth").
		body(Mono.just(usr),UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);
objUsuario = response.block();

return objUsuario;
}

public UsuarioVO borrarUsuario(UsuarioVO usuarioDto) {
	try {
		WebClient webClient = WebClient.create(URL);
		  UsuarioVO objUsuario = null;
		  Mono<UsuarioVO> response =webClient.post().uri(URL+"/borrarUsuario")
				  .body(Mono.just(usuarioDto) , UsuarioVO.class).retrieve().bodyToMono(UsuarioVO.class);
		  
		  objUsuario = response.block();
		  return objUsuario;
		  
	   
	  } catch (WebClientResponseException e) {
		  e.getMessage();
		       System.out.println("----"+ e.getMessage());
		       return null;
	  }

}

public String listarVentas() {
	
	try {

        URL url = new URL(URL+"/listarVentas");//your url i.e fetch data from .
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String json = br.readLine();
        conn.disconnect();
        return json;
    } catch (Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }
	return null;
}
}
