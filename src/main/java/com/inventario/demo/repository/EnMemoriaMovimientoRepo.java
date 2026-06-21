package com.inventario.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.MovimientoInventario;

@Repository
public class EnMemoriaMovimientoRepo
        extends MemoriaRepositorio<MovimientoInventario, Long>
        implements MovimientoRepo {

    @Override
    public MovimientoInventario save(MovimientoInventario movimiento) {

        if (movimiento == null) {
            throw new IllegalArgumentException("El movimiento no puede ser nulo");
        }

        if (movimiento.getId() == null) {
            movimiento.setId(idGenerator.incrementAndGet());
        }

        dataStore.put(movimiento.getId(), movimiento);

        return movimiento;
    }

    @Override
    public List<MovimientoInventario> findByProductoId(Long productoId) {

        return dataStore.values()
                .stream()
                .filter(movimiento ->
                        movimiento.getProductoId().equals(productoId))
                .toList();
    }
}