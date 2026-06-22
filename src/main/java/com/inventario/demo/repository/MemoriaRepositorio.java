package com.inventario.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

/**
 * Repositorio base en memoria que implementa operaciones CRUD comunes.
 *
 * @param <T> tipo de entidad gestionada
 * @param <ID> tipo del identificador de la entidad
 */
public abstract class MemoriaRepositorio<T, ID> implements Repositorio<T, ID> {

    protected final ConcurrentHashMap<ID, T> dataStore;
    protected final AtomicLong idGenerator;

    /**
     * Inicializa el almacén en memoria y el generador de identificadores.
     */
    public MemoriaRepositorio() {
        this.dataStore = new ConcurrentHashMap<>();
        this.idGenerator = new AtomicLong(1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataStore.get(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(ID id) {
        dataStore.remove(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(ID id) {
        return dataStore.containsKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long count() {
        return dataStore.size();
    }
}