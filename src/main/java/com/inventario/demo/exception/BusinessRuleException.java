package com.inventario.demo.exception;

/**
 * Excepción lanzada cuando se viola una regla de negocio del inventario.
 */
public class BusinessRuleException extends RuntimeException {

    /**
     * Crea una excepción de regla de negocio con un mensaje descriptivo.
     *
     * @param message mensaje que describe la violación de la regla de negocio
     */
    public BusinessRuleException(String message) {
        super(message);
    }
}
