package com.inventario.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.demo.dto.CategoriaRequest;
import com.inventario.demo.model.Categoria;
import com.inventario.demo.service.CategoriaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
/**
 * Controlador REST para gestionar las categorías de inventario.
 */
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Devuelve todas las categorías disponibles.
     *
     * @return respuesta HTTP con la lista de categorías
     */
    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    /**
     * Recupera una categoría por su identificador.
     *
     * @param id identificador de la categoría
     * @return respuesta HTTP con la categoría encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    /**
     * Crea una nueva categoría.
     *
     * @param request datos de la categoría a crear
     * @return respuesta HTTP con la categoría creada
     */
    @PostMapping
    public ResponseEntity<Categoria> crear(
            @Valid @RequestBody CategoriaRequest request) {

        Categoria categoria = categoriaService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
    }

    /**
     * Actualiza una categoría existente.
     *
     * @param id identificador de la categoría a actualizar
     * @param request datos actualizados de la categoría
     * @return respuesta HTTP con la categoría actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CategoriaRequest request) {

        return ResponseEntity.ok(categoriaService.update(id, request));
    }

    /**
     * Elimina una categoría por su identificador.
     *
     * @param id identificador de la categoría a eliminar
     * @return respuesta HTTP sin contenido
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        categoriaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}