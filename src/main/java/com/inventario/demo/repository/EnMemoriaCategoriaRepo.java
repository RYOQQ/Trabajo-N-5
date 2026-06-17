package com.inventario.demo.repository;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.Categoria;

@Repository
public class EnMemoriaCategoriaRepo
        extends MemoriaRepositorio<Categoria, Long>
        implements CategoriaRepo {

    @Override
    public Categoria save(Categoria categoria) {

        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no puede ser nula");
        }

        if (categoria.getId() == null) {
            categoria.setId(idGenerator.incrementAndGet());
        }

        dataStore.put(categoria.getId(), categoria);

        return categoria;
    }
}