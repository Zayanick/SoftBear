package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ClientesVO;
import reactor.core.publisher.Mono;

@Service
public class ClienteDAO {

private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;

	
public String listarUsuarios() {
		
	try {

        URL url = new URL(URL+"/listarClientes");//your url i.e fetch data from .
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


public ClientesVO nuevoUsuario(ClientesVO usuarioDto) {

try {
	WebClient webClient = WebClient.create(URL);
	ClientesVO  objCliente = null;
	Mono<ClientesVO > response = webClient.post().uri(URL + "/registrarClientes")
			.body(Mono.just(usuarioDto), ClientesVO.class).retrieve().bodyToMono(ClientesVO.class);

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
}
