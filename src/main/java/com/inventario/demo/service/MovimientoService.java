package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.dto.MovimientoRequest;
import com.inventario.demo.model.MovimientoInventario;

public interface MovimientoService {

    MovimientoInventario registrarMovimiento(MovimientoRequest request);

    List<MovimientoInventario> findAll();

    MovimientoInventario findById(Long id);

    List<MovimientoInventario> findByProducto(Long productoId);
}