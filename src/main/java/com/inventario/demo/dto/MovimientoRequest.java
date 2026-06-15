package com.inventario.demo.dto;

import com.inventario.demo.model.TipoMovimiento;
import jakarta.validation.constraints.*;

public record MovimientoRequest(

    @NotNull
    Long productoId,

    @NotNull
    TipoMovimiento tipo,

    @Positive
    int cantidad,

    @NotBlank
    String motivo

) {}
