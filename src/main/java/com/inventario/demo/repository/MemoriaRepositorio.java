package com.inventario.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

public abstract class MemoriaRepositorio<T, ID> implements Repositorio<T, ID> {

    protected final ConcurrentHashMap<ID, T> dataStore;
    protected final AtomicLong idGenerator;

    public MemoriaRepositorio() {
        this.dataStore = new ConcurrentHashMap<>();
        this.idGenerator = new AtomicLong(1);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(dataStore.get(id));
    }

    @Override
    public void deleteById(ID id) {
        dataStore.remove(id);
    }

    @Override
    public boolean existsById(ID id) {
        return dataStore.containsKey(id);
    }

    @Override
    public long count() {
        return dataStore.size();
    }
}