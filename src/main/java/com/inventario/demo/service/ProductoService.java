package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.dto.ProductoRequest;
import com.inventario.demo.model.Producto;

public interface ProductoService {

    List<Producto> findAll();

    Producto findById(Long id);

    Producto save(ProductoRequest request);

    Producto update(Long id, ProductoRequest request);

    void delete(Long id);

    List<Producto> findByCategoria(Long categoriaId);

    List<Producto> buscarPorNombre(String texto);
}