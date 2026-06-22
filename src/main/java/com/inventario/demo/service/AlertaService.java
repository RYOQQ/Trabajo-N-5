package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.model.NivelAlerta;
import com.inventario.demo.model.Producto;

/**
 * Servicio para evaluar el nivel de alerta de stock de productos.
 */
public interface AlertaService {

    /**
     * Determina el nivel de alerta de un producto según su stock.
     *
     * @param producto producto a evaluar
     * @return nivel de alerta correspondiente
     */
    NivelAlerta obtenerNivelAlerta(Producto producto);

    /**
     * Devuelve los productos con stock bajo.
     *
     * @return lista de productos con stock bajo
     */
    List<Producto> productosConStockBajo();

    /**
     * Devuelve los productos con stock crítico.
     *
     * @return lista de productos con stock crítico
     */
    List<Producto> productosConStockCritico();
}