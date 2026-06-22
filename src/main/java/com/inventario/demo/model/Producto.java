package com.inventario.demo.model;

import java.util.concurrent.atomic.AtomicInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * Representa un producto del inventario con sus propiedades y stock.
 */
public class Producto {

    private Long id;
    private String nombre;
    private String descripcion;
    private double precio;
    private Categoria categoria;
    private AtomicInteger stock;

    /**
     * Constructor por defecto necesario para la deserialización.
     */
    public Producto() {}

    /**
     * Constructor completo de producto.
     *
     * @param id identificador único del producto
     * @param nombre nombre del producto
     * @param descripcion descripción del producto
     * @param precio precio unitario del producto
     * @param categoria categoría asociada al producto
     * @param stock cantidad inicial de stock
     */
    public Producto(Long id, String nombre, String descripcion, double precio, Categoria categoria, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = new AtomicInteger(stock);
    }

    /**
     * Obtiene la cantidad actual de stock disponible.
     *
     * @return stock actual del producto
     */
    public int getStock() {
        return stock.get();
    }

    /**
     * Incrementa el stock del producto.
     *
     * @param cantidad cantidad a añadir al stock
     * @return stock resultante después de la actualización
     */
    public int incrementarStock(int cantidad) {
        return stock.addAndGet(cantidad);
    }

    /**
     * Decrementa el stock del producto.
     *
     * @param cantidad cantidad a restar del stock
     * @return stock resultante después de la actualización
     */
    public int decrementarStock(int cantidad) {
        return stock.addAndGet(-cantidad);
    }
}