package com.inventario.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.demo.model.Producto;
import com.inventario.demo.service.AlertaService;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @GetMapping("/bajo")
    public ResponseEntity<List<Producto>> stockBajo() {
        return ResponseEntity.ok(alertaService.productosConStockBajo());
    }

    @GetMapping("/critico")
    public ResponseEntity<List<Producto>> stockCritico() {
        return ResponseEntity.ok(alertaService.productosConStockCritico());
    }
}