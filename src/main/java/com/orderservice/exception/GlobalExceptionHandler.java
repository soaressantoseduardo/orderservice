package com.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Classe de tratamento global de exceções.
 * Esta classe captura exceções lançadas em toda a aplicação e fornece
 * respostas apropriadas aos clientes.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Trata a exceção de pedido não encontrado.
     *
     * @param ex A exceção que foi lançada.
     * @return Uma resposta indicando que o pedido não foi encontrado.
     */
	@ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Trata a exceção de pedido duplicado.
     *
     * @param ex A exceção que foi lançada.
     * @return Uma resposta indicando que o pedido duplicado foi tentado.
     */
    @ExceptionHandler(DuplicatedOrderException.class)
    public ResponseEntity<String> handleDuplicatedOrder(DuplicatedOrderException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    // Outros tratadores de exceções podem ser adicionados aqui
}