package com.inventario.demo.repository;

import java.util.List;

import com.inventario.demo.model.MovimientoInventario;

public interface MovimientoRepo extends Repositorio<MovimientoInventario, Long> {

    /**
     * Busca movimientos por identificador de producto.
     *
     * @param productoId identificador del producto
     * @return lista de movimientos asociados al producto
     */
    List<MovimientoInventario> findByProductoId(Long productoId);
}