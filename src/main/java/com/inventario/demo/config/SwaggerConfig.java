package com.inventario.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI inventarioAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("API Inventario")
                        .description("Sistema de gestión de inventario")
                        .version("1.0"));
    }
}