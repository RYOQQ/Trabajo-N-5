package com.inventario.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inventario.demo.dto.CategoriaRequest;
import com.inventario.demo.exception.ResourceNotFoundException;
import com.inventario.demo.model.Categoria;
import com.inventario.demo.repository.CategoriaRepo;

@Service
/**
 * Implementación del servicio de categorías.
 */
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepo categoriaRepo;

    public CategoriaServiceImpl(CategoriaRepo categoriaRepo) {
        this.categoriaRepo = categoriaRepo;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Categoria> findAll() {
        return categoriaRepo.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Categoria findById(Long id) {

        return categoriaRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Categoria save(CategoriaRequest request) {

        Categoria categoria = new Categoria();
        categoria.setNombre(request.nombre());

        return categoriaRepo.save(categoria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Categoria update(Long id, CategoriaRequest request) {

        Categoria categoria = findById(id);

        categoria.setNombre(request.nombre());

        return categoriaRepo.save(categoria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Long id) {

        findById(id);

        categoriaRepo.deleteById(id);
    }
}