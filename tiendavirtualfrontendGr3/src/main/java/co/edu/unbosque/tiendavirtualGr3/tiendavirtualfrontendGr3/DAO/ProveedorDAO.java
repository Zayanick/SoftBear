package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.ProveedoresVO;
import reactor.core.publisher.Mono;

public class ProveedorDAO {
private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;

	
public String listarProveedores() {
		
	try {

        URL url = new URL(URL+"/listarProveedores");//your url i.e fetch data from .
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


public ProveedoresVO nuevoProveedor(ProveedoresVO usuarioDto) {

try {
	WebClient webClient = WebClient.create(URL);
	ProveedoresVO  objCliente = null;
	Mono<ProveedoresVO> response = webClient.post().uri(URL + "/registrarProveedores")
			.body(Mono.just(usuarioDto), ProveedoresVO.class).retrieve().bodyToMono(ProveedoresVO.class);

	objCliente = response.block();
	return objCliente;

} catch (WebClientResponseException e) {
	e.getMessage();
	System.out.println("---->" + e.getMessage());
	return null;
}

}
}
