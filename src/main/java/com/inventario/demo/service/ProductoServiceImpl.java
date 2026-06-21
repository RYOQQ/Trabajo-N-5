package com.inventario.demo.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import com.inventario.demo.dto.ProductoRequest;
import com.inventario.demo.exception.ResourceNotFoundException;
import com.inventario.demo.model.Categoria;
import com.inventario.demo.model.Producto;
import com.inventario.demo.repository.CategoriaRepo;
import com.inventario.demo.repository.ProductoRepo;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepo productoRepo;
    private final CategoriaRepo categoriaRepo;

    public ProductoServiceImpl(ProductoRepo productoRepo,
                               CategoriaRepo categoriaRepo) {

        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public List<Producto> findAll() {
        return productoRepo.findAll();
    }

    @Override
    public Producto findById(Long id) {

        return productoRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Producto no encontrado"));
    }

    @Override
    public Producto save(ProductoRequest request) {

        Categoria categoria = categoriaRepo.findById(request.categoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada"));

        Producto producto = new Producto();

        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setCategoria(categoria);
        producto.setStock(new AtomicInteger(request.stockInicial()));

        return productoRepo.save(producto);
    }

    @Override
    public Producto update(Long id, ProductoRequest request) {

        Producto producto = findById(id);

        Categoria categoria = categoriaRepo.findById(request.categoriaId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Categoría no encontrada"));

        producto.setNombre(request.nombre());
        producto.setDescripcion(request.descripcion());
        producto.setPrecio(request.precio());
        producto.setCategoria(categoria);

        return productoRepo.save(producto);
    }

    @Override
    public void delete(Long id) {

        findById(id);

        productoRepo.deleteById(id);
    }

    @Override
    public List<Producto> findByCategoria(Long categoriaId) {
        return productoRepo.findByCategoria(categoriaId);
    }

    @Override
    public List<Producto> buscarPorNombre(String texto) {
        return productoRepo.buscarPorNombre(texto);
    }
}