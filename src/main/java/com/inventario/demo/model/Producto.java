package com.inventario.demo.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private AtomicInteger stock;

    public Producto() {}

    public Producto(Long id, String nombre, String descripcion, double precio, Categoria categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = new AtomicInteger(stock);
    }

    public int getStock() {
        return stock.get();
    }

    public int incrementarStock(int cantidad) {
        return stock.addAndGet(cantidad);
    }

    public int decrementarStock(int cantidad) {
        return stock.addAndGet(-cantidad);
    }
}