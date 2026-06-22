package com.inventario.demo.repository;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz genérica para repositorios de datos en memoria.
 *
 * @param <T> tipo de entidad gestionada
 * @param <ID> tipo del identificador de la entidad
 */
public interface Repositorio<T, ID> {

    /**
     * Devuelve todos los elementos almacenados.
     *
     * @return lista con todos los elementos
     */
    List<T> findAll();

    /**
     * Busca un elemento por su identificador.
     *
     * @param id identificador del elemento
     * @return optional con el elemento si existe
     */
    Optional<T> findById(ID id);

    /**
     * Guarda o actualiza una entidad.
     *
     * @param entity entidad a guardar
     * @return entidad guardada
     */
    T save(T entity);

    /**
     * Elimina un elemento por su identificador.
     *
     * @param id identificador del elemento a eliminar
     */
    void deleteById(ID id);

    /**
     * Comprueba si existe un elemento con el identificador dado.
     *
     * @param id identificador a comprobar
     * @return true si existe el elemento
     */
    boolean existsById(ID id);

    /**
     * Cuenta los elementos almacenados.
     *
     * @return número de elementos guardados
     */
    long count();
}
