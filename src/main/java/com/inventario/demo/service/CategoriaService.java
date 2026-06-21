package com.inventario.demo.service;

import com.inventario.demo.dto.CategoriaRequest;
import com.inventario.demo.model.Categoria;
import java.util.List;

public interface CategoriaService {

    List<Categoria> findAll();

    Categoria findById(Long id);

    Categoria save(CategoriaRequest request);

    Categoria update(Long id, CategoriaRequest request);

    void delete(Long id);
}