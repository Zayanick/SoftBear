package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.EstudianteVO;
import co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.UsuarioVO;
import reactor.core.publisher.Mono;

@Service
public class EstudianteDAO {
	
	private static final String URL = "http://localhost:8080";
	
	@Autowired
	private WebClient webClient;

	
public String listarUsuarios() {
		
		try {

            URL url = new URL(URL+"/listarEstudiantes");//your url i.e fetch data from .
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


public EstudianteVO nuevoUsuario(EstudianteVO usuarioDto) {

	try {
		WebClient webClient = WebClient.create(URL);
		EstudianteVO objEstudiante = null;
		Mono<EstudianteVO> response = webClient.post().uri(URL + "/registrarEstudiante")
				.body(Mono.just(usuarioDto), EstudianteVO.class).retrieve().bodyToMono(EstudianteVO.class);

		objEstudiante = response.block();
		return objEstudiante;

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
