package com.inventario.demo.service;

import java.util.List;

import com.inventario.demo.dto.ProductoRequest;
import com.inventario.demo.model.Producto;

/**
 * Servicio para la lógica de negocio relacionada con productos.
 */
public interface ProductoService {

    /**
     * Devuelve todos los productos del inventario.
     *
     * @return lista de productos
     */
    List<Producto> findAll();

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto
     * @return producto encontrado
     */
    Producto findById(Long id);

    /**
     * Crea un nuevo producto a partir de la solicitud recibida.
     *
     * @param request datos del producto a crear
     * @return producto guardado
     */
    Producto save(ProductoRequest request);

    /**
     * Actualiza un producto existente.
     *
     * @param id identificador del producto a actualizar
     * @param request datos actualizados del producto
     * @return producto actualizado
     */
    Producto update(Long id, ProductoRequest request);

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto a eliminar
     */
    void delete(Long id);

    /**
     * Busca productos pertenecientes a una categoría.
     *
     * @param categoriaId identificador de la categoría
     * @return lista de productos de la categoría
     */
    List<Producto> findByCategoria(Long categoriaId);

    /**
     * Busca productos cuyo nombre contiene el texto indicado.
     *
     * @param texto texto de búsqueda en el nombre
     * @return lista de productos coincidentes
     */
    List<Producto> buscarPorNombre(String texto);
}