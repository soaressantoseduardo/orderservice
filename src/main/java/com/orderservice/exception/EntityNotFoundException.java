package com.orderservice.exception;

/**
 * Exceção lançada quando uma entidade não é encontrada.
 * 
 * Esta é uma exceção personalizada que é lançada quando um pedido ou produto
 * pedido pelo usuário não está presente no banco de dados.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class EntityNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
        super(message);
    }
}