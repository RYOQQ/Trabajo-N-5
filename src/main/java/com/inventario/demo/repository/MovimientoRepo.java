package com.inventario.demo.repository;

import java.util.List;

import com.inventario.demo.model.MovimientoInventario;

public interface MovimientoRepo extends Repositorio<MovimientoInventario, Long> {

    List<MovimientoInventario> findByProductoId(Long productoId);
}