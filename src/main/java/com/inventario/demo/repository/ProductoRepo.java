package com.inventario.demo.repository;

import com.inventario.demo.model.Producto;
import java.util.List;

public interface ProductoRepo extends Repositorio<Producto, Long> {

    /**
     * Busca productos por categoría.
     *
     * @param categoriaId identificador de la categoría
     * @return lista de productos de la categoría
     */
    List<Producto> findByCategoria(Long categoriaId);

    /**
     * Busca productos cuyo nombre contiene el texto dado.
     *
     * @param texto texto de búsqueda
     * @return lista de productos coincidentes
     */
    List<Producto> buscarPorNombre(String texto);
}
