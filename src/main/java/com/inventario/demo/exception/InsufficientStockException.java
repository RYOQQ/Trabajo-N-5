package com.inventario.demo.exception;

/**
 * Excepción lanzada cuando se intenta operar sobre un producto con stock insuficiente.
 */
public class InsufficientStockException extends RuntimeException {

    /**
     * Crea una excepción de stock insuficiente con un mensaje descriptivo.
     *
     * @param message mensaje que describe el error de stock
     */
    public InsufficientStockException(String message) {
        super(message);
    }
}
