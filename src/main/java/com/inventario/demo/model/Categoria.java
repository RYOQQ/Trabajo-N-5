package com.inventario.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
/**
 * Representa una categoría de producto dentro del inventario.
 */
public class Categoria {

    private Long id;
    private String nombre;

    /**
     * Constructor por defecto necesario para la deserialización.
     */
    public Categoria() {}

    /**
     * Constructor completo de categoría.
     *
     * @param id identificador único de la categoría
     * @param nombre nombre de la categoría
     */
    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}