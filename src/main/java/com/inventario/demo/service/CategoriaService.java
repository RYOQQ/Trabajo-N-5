package com.inventario.demo.service;

import com.inventario.demo.dto.CategoriaRequest;
import com.inventario.demo.model.Categoria;
import java.util.List;

/**
 * Servicio para la lógica de negocio de categorías.
 */
public interface CategoriaService {

    /**
     * Devuelve todas las categorías registradas.
     *
     * @return lista de categorías
     */
    List<Categoria> findAll();

    /**
     * Busca una categoría por su identificador.
     *
     * @param id identificador de la categoría
     * @return categoría encontrada
     */
    Categoria findById(Long id);

    /**
     * Crea una nueva categoría.
     *
     * @param request datos de la categoría a crear
     * @return categoría guardada
     */
    Categoria save(CategoriaRequest request);

    /**
     * Actualiza una categoría existente.
     *
     * @param id identificador de la categoría a actualizar
     * @param request datos actualizados de la categoría
     * @return categoría actualizada
     */
    Categoria update(Long id, CategoriaRequest request);

    /**
     * Elimina una categoría por su identificador.
     *
     * @param id identificador de la categoría a eliminar
     */
    void delete(Long id);
}