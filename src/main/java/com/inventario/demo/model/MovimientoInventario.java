package com.inventario.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MovimientoInventario {

    private Long id;
    private Long productoId;
    private TipoMovimiento tipo;
    private int cantidad;
    private String motivo;
    private LocalDateTime fecha;

    public MovimientoInventario() {}

    public MovimientoInventario(Long id, Long productoId, TipoMovimiento tipo, int cantidad, String motivo, LocalDateTime fecha) {
        this.id = id;
        this.productoId = productoId;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fecha = fecha;
    }
}
