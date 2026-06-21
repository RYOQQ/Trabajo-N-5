package com.inventario.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.demo.dto.MovimientoRequest;
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
    public MovimientoInventario registrarMovimiento(MovimientoRequest request) {

        Producto producto = productoRepo.findById(request.productoId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Producto no encontrado"));

        if (request.tipo() == TipoMovimiento.ENTRADA) {

            producto.incrementarStock(request.cantidad());

        } else {

            if (producto.getStock() < request.cantidad()) {
                throw new InsufficientStockException("Stock insuficiente");
            }

            producto.decrementarStock(request.cantidad());
        }

        productoRepo.save(producto);

        MovimientoInventario movimiento = new MovimientoInventario();

        movimiento.setProductoId(request.productoId());
        movimiento.setTipo(request.tipo());
        movimiento.setCantidad(request.cantidad());
        movimiento.setMotivo(request.motivo());
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