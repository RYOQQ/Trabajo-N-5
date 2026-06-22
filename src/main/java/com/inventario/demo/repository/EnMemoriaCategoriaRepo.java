package com.inventario.demo.repository;

import org.springframework.stereotype.Repository;

import com.inventario.demo.model.Categoria;

@Repository
/**
 * Implementación en memoria del repositorio de categorías.
 */
public class EnMemoriaCategoriaRepo
        extends MemoriaRepositorio<Categoria, Long>
        implements CategoriaRepo {

    /**
     * Guarda o actualiza una categoría en memoria.
     *
     * @param categoria entidad categoría a guardar
     * @return categoría guardada con identificador asignado
     */
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