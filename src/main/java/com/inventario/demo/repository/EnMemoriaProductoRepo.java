package com.inventario.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.Producto;

@Repository
public class EnMemoriaProductoRepo
        extends MemoriaRepositorio<Producto, Long>
        implements ProductoRepo {

    @Override
    public Producto save(Producto producto) {

        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }

        if (producto.getId() == null) {
            producto.setId(idGenerator.incrementAndGet());
        }

        dataStore.put(producto.getId(), producto);

        return producto;
    }

    @Override
    public List<Producto> findByCategoria(Long categoriaId) {

        return dataStore.values()
                .stream()
                .filter(producto ->
                        producto.getCategoria() != null
                        && producto.getCategoria().getId().equals(categoriaId))
                .toList();
    }

    @Override
    public List<Producto> buscarPorNombre(String texto) {

        String textoLower = texto.toLowerCase();

        return dataStore.values()
                .stream()
                .filter(producto ->
                        producto.getNombre() != null
                        && producto.getNombre()
                                   .toLowerCase()
                                   .contains(textoLower))
                .toList();
    }
}