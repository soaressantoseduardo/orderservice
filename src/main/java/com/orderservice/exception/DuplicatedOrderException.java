package com.orderservice.exception;

/**
 * Exceção personalizada para indicar que um pedido duplicado foi tentado.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class DuplicatedOrderException extends RuntimeException {
    public DuplicatedOrderException(String message) {
        super(message);
    }
}