package com.inventario.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.demo.dto.ProductoRequest;
import com.inventario.demo.model.Producto;
import com.inventario.demo.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
/**
 * Controlador REST para gestionar los recursos de productos.
 */
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Devuelve todos los productos registrados.
     *
     * @return respuesta HTTP con la lista de productos
     */
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.findAll());
    }

    /**
     * Recupera un producto por su identificador.
     *
     * @param id identificador del producto
     * @return respuesta HTTP con el producto encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.findById(id));
    }

    /**
     * Crea un nuevo producto a partir de la solicitud recibida.
     *
     * @param request datos del producto a crear
     * @return respuesta HTTP con el producto creado
     */
    @PostMapping
    public ResponseEntity<Producto> crear(
            @Valid @RequestBody ProductoRequest request) {

        Producto producto = productoService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto a actualizar
     * @param request datos actualizados del producto
     * @return respuesta HTTP con el producto actualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ProductoRequest request) {

        return ResponseEntity.ok(productoService.update(id, request));
    }

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto a eliminar
     * @return respuesta HTTP sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        productoService.delete(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Busca productos por la categoría indicada.
     *
     * @param categoriaId identificador de la categoría
     * @return respuesta HTTP con la lista de productos de la categoría
     */
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Producto>> buscarPorCategoria(
            @PathVariable Long categoriaId) {

        return ResponseEntity.ok(productoService.findByCategoria(categoriaId));
    }

    /**
     * Busca productos por nombre.
     *
     * @param nombre texto a buscar en el nombre del producto
     * @return respuesta HTTP con la lista de productos coincidentes
     */
    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarPorNombre(
            @RequestParam String nombre) {

        return ResponseEntity.ok(productoService.buscarPorNombre(nombre));
    }
}