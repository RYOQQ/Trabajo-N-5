package com.inventario.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.demo.exception.InsufficientStockException;
import com.inventario.demo.exception.ResourceNotFoundException;
import com.inventario.demo.model.MovimientoInventario;
import com.inventario.demo.model.Producto;
import com.inventario.demo.model.TipoMovimiento;
import com.inventario.demo.repository.MovimientoRepo;
import com.inventario.demo.repository.ProductoRepo;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepo movimientoRepo;
    private final ProductoRepo productoRepo;

    public MovimientoServiceImpl(MovimientoRepo movimientoRepo,
                                 ProductoRepo productoRepo) {

        this.movimientoRepo = movimientoRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public MovimientoInventario registrarMovimiento(MovimientoInventario movimiento) {

        Producto producto = productoRepo.findById(movimiento.getProductoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Producto no encontrado"));

        if (movimiento.getTipo() == TipoMovimiento.ENTRADA) {

            producto.incrementarStock(movimiento.getCantidad());

        } else {

            if (producto.getStock() < movimiento.getCantidad()) {
                throw new InsufficientStockException("Stock insuficiente");
            }

            producto.decrementarStock(movimiento.getCantidad());
        }

        productoRepo.save(producto);

        movimiento.setFecha(LocalDateTime.now());

        return movimientoRepo.save(movimiento);
    }

    @Override
    public List<MovimientoInventario> findAll() {
        return movimientoRepo.findAll();
    }

    @Override
    public MovimientoInventario findById(Long id) {

        return movimientoRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Movimiento no encontrado"));
    }

    @Override
    public List<MovimientoInventario> findByProducto(Long productoId) {
        return movimientoRepo.findByProductoId(productoId);
    }
}