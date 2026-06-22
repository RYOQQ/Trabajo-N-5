package com.inventario.demo.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * Representa un movimiento de inventario registrado en el sistema.
 */
public class MovimientoInventario {

    private Long id;
    private Long productoId;
    private TipoMovimiento tipo;
    private int cantidad;
    private String motivo;
    private LocalDateTime fecha;

    /**
     * Constructor por defecto necesario para la deserialización.
     */
    public MovimientoInventario() {}

    /**
     * Constructor completo de movimiento de inventario.
     *
     * @param id identificador del movimiento
     * @param productoId identificador del producto asociado
     * @param tipo tipo de movimiento (entrada/salida)
     * @param cantidad cantidad movida
     * @param motivo motivo del movimiento
     * @param fecha fecha y hora del movimiento
     */
    public MovimientoInventario(Long id, Long productoId, TipoMovimiento tipo, int cantidad, String motivo, LocalDateTime fecha) {
        this.id = id;
        this.productoId = productoId;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.motivo = motivo;
        this.fecha = fecha;
    }
}
