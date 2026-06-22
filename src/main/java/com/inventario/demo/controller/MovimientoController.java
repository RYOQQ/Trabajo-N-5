package com.inventario.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.demo.dto.MovimientoRequest;
import com.inventario.demo.model.MovimientoInventario;
import com.inventario.demo.service.MovimientoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/movimientos")
/**
 * Controlador REST para gestionar los movimientos de inventario.
 */
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    /**
     * Devuelve todos los movimientos registrados.
     *
     * @return respuesta HTTP con la lista de movimientos
     */
    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listar() {
        return ResponseEntity.ok(movimientoService.findAll());
    }

    /**
     * Recupera un movimiento por su identificador.
     *
     * @param id identificador del movimiento
     * @return respuesta HTTP con el movimiento encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.findById(id));
    }

    /**
     * Registra un nuevo movimiento de inventario.
     *
     * @param request datos del movimiento a registrar
     * @return respuesta HTTP con el movimiento registrado
     */
    @PostMapping
    public ResponseEntity<MovimientoInventario> registrar(
            @Valid @RequestBody MovimientoRequest request) {

        MovimientoInventario movimiento =
                movimientoService.registrarMovimiento(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(movimiento);
    }

    /**
     * Busca movimientos por identificador de producto.
     *
     * @param productoId identificador del producto
     * @return respuesta HTTP con los movimientos asociados al producto
     */
    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<MovimientoInventario>> buscarPorProducto(
            @PathVariable Long productoId) {

        return ResponseEntity.ok(
                movimientoService.findByProducto(productoId));
    }
}