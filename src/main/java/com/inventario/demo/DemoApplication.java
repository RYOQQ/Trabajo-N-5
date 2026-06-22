package com.inventario.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * Aplicación Spring Boot del sistema de inventario.
 * Contiene el punto de entrada principal para iniciar la aplicación.
 */
public class DemoApplication {

	/**
	 * Inicia el contexto de Spring Boot.
	 *
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
