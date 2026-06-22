package com.inventario.demo.exception;

/**
 * Excepción lanzada cuando un recurso no puede ser encontrado en el inventario.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Crea una excepción de recurso no encontrado con un mensaje descriptivo.
     *
     * @param message mensaje que describe el recurso faltante
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}