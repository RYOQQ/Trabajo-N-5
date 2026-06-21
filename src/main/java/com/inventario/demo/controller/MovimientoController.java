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
public class MovimientoController {

    private final MovimientoService movimientoService;

    public MovimientoController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    @GetMapping
    public ResponseEntity<List<MovimientoInventario>> listar() {
        return ResponseEntity.ok(movimientoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(movimientoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MovimientoInventario> registrar(
            @Valid @RequestBody MovimientoRequest request) {

        MovimientoInventario movimiento =
                movimientoService.registrarMovimiento(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(movimiento);
    }

    @GetMapping("/producto/{productoId}")
    public ResponseEntity<List<MovimientoInventario>> buscarPorProducto(
            @PathVariable Long productoId) {

        return ResponseEntity.ok(
                movimientoService.findByProducto(productoId));
    }
}