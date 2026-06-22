package com.inventario.demo.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO para la creación y actualización de categorías.
 */
public record CategoriaRequest(

        @NotBlank
        String nombre

) {}