package com.orderservice.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.Set;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Teste de validação para OrderRequest.
 * 
 * Esta classe contém testes que validam as regras de negócio para o OrderRequest
 * utilizando validadores da API de validação padrão do Java.
 *  
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com 
 */
class OrderRequestValidationTest {

    private Validator validator;

    /**
     * Configura o validador antes da execução de cada teste.
     * 
     * Cria uma instância de Validator utilizando as fábricas padrão.
     */
    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Testa se um OrderRequest válido não gera violações.
     * 
     * Verifica se o validador não encontra violações ao tentar validar um
     * OrderRequest corretamente preenchido.
     */
    @Test
    void testOrderRequestValid() {
        ProductRequest productRequest = new ProductRequest("Produto Teste", 10.0);
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setProducts(Collections.singletonList(productRequest));

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);

        assertTrue(violations.isEmpty());
    }

    /**
     * Testa se um OrderRequest com uma lista de produtos vazia gera a violação correta.
     * 
     * Garante que uma exceção de validação é lançada quando o OrderRequest
     * está incorretamente preenchido com uma lista de produtos vazia.
     */
    @Test
    void testOrderRequestInvalidWithEmptyProducts() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setProducts(Collections.emptyList());

        Set<ConstraintViolation<OrderRequest>> violations = validator.validate(orderRequest);

        assertFalse(violations.isEmpty());
        // Ajuste para pegar a mensagem correta baseado nas anotações de validação no DTO
        String expectedMessage = "A lista de produtos não pode ser vazia."; 
        assertEquals(expectedMessage, violations.iterator().next().getMessage());
    }
}