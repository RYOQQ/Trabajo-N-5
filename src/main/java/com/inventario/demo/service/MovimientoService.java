package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.dto.MovimientoRequest;
import com.inventario.demo.model.MovimientoInventario;

/**
 * Servicio para gestionar movimientos de inventario.
 */
public interface MovimientoService {

    /**
     * Registra un nuevo movimiento de inventario.
     *
     * @param request datos del movimiento
     * @return movimiento registrado
     */
    MovimientoInventario registrarMovimiento(MovimientoRequest request);

    /**
     * Devuelve todos los movimientos registrados.
     *
     * @return lista de movimientos
     */
    List<MovimientoInventario> findAll();

    /**
     * Busca un movimiento por su identificador.
     *
     * @param id identificador del movimiento
     * @return movimiento encontrado
     */
    MovimientoInventario findById(Long id);

    /**
     * Busca movimientos asociados a un producto.
     *
     * @param productoId identificador del producto
     * @return lista de movimientos del producto
     */
    List<MovimientoInventario> findByProducto(Long productoId);
}