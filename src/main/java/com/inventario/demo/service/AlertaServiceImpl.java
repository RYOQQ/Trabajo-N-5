package com.inventario.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.demo.model.NivelAlerta;
import com.inventario.demo.model.Producto;
import com.inventario.demo.repository.ProductoRepo;

@Service
/**
 * Implementación del servicio de alertas de stock.
 */
public class AlertaServiceImpl implements AlertaService {

    private static final int STOCK_BAJO = 10;
    private static final int STOCK_CRITICO = 5;

    private final ProductoRepo productoRepo;

    public AlertaServiceImpl(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NivelAlerta obtenerNivelAlerta(Producto producto) {

        Integer stockObj = producto.getStock();
        int stock = (stockObj == null) ? 0 : stockObj.intValue();

        if (stock <= STOCK_CRITICO) {
            return NivelAlerta.CRITICO;
        }

        if (stock <= STOCK_BAJO) {
            return NivelAlerta.BAJO;
        }

        return NivelAlerta.NORMAL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> productosConStockBajo() {

        return productoRepo.findAll()
                .stream()
                .filter(producto -> obtenerNivelAlerta(producto) == NivelAlerta.BAJO)
                .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Producto> productosConStockCritico() {

        return productoRepo.findAll()
                .stream()
                .filter(producto -> obtenerNivelAlerta(producto) == NivelAlerta.CRITICO)
                .toList();
    }
}