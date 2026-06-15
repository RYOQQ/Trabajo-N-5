package com.inventario.demo.dto;

import jakarta.validation.constraints.*;

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
