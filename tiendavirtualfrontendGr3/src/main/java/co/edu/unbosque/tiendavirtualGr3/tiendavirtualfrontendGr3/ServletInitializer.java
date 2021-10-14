package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TiendavirtualfrontendGr3Application.class);
	}

}
