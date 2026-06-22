package com.inventario.demo.dto;

import jakarta.validation.constraints.*;

/**
 * DTO para la creación y actualización de productos.
 */
public record ProductoRequest(

    @NotBlank
    String nombre,

    String descripcion,

    @PositiveOrZero
    double precio,

    @PositiveOrZero
    int stockInicial,

    @NotNull
    Long categoriaId

) {}
