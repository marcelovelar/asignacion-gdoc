package com.example.controlpostulacionbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ControlPostulacionBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlPostulacionBackendApplication.class, args);
	}

}

//PARA LEVANTAR EN PRODUCCION SE DEBE USAR EL CODIGO COMENTADO ABAJO
//Y COMENTAR EL CODIGO DE ARRIBA
/*package com.example.controlpostulacionbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ControlPostulacionBackendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ControlPostulacionBackendApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ControlPostulacionBackendApplication.class, args);
	}
}*/

