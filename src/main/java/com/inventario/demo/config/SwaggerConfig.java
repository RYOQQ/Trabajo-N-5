package com.inventario.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * Configuración de OpenAPI para la documentación de la API del inventario.
 */
public class SwaggerConfig {

    /**
     * Crea y configura el bean OpenAPI para la documentación Swagger.
     *
     * @return la definición OpenAPI de la API de inventario
     */
    @Bean
    public OpenAPI inventarioAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("API Inventario")
                        .description("Sistema de gestión de inventario")
                        .version("1.0"));
    }
}