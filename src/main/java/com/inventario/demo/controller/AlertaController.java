package com.inventario.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.inventario.demo.model.Producto;
import com.inventario.demo.service.AlertaService;

/**
 * Controlador REST para consultar productos con niveles de stock en alerta.
 */
@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    /**
     * Devuelve los productos con stock bajo.
     *
     * @return respuesta HTTP con la lista de productos en estado bajo de stock
     */
    @GetMapping("/bajo")
    public ResponseEntity<List<Producto>> stockBajo() {
        return ResponseEntity.ok(alertaService.productosConStockBajo());
    }

    /**
     * Devuelve los productos con stock crítico.
     *
     * @return respuesta HTTP con la lista de productos en estado crítico de stock
     */
    @GetMapping("/critico")
    public ResponseEntity<List<Producto>> stockCritico() {
        return ResponseEntity.ok(alertaService.productosConStockCritico());
    }
}