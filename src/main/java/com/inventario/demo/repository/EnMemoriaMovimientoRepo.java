package com.inventario.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.MovimientoInventario;

@Repository
/**
 * Implementación en memoria del repositorio de movimientos de inventario.
 */
public class EnMemoriaMovimientoRepo
        extends MemoriaRepositorio<MovimientoInventario, Long>
        implements MovimientoRepo {

    /**
     * Guarda o actualiza un movimiento en memoria.
     *
     * @param movimiento entidad movimiento a guardar
     * @return movimiento guardado con identificador asignado
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MovimientoInventario> findByProductoId(Long productoId) {

        return dataStore.values()
                .stream()
                .filter(movimiento ->
                        movimiento.getProductoId().equals(productoId))
                .toList();
    }
}