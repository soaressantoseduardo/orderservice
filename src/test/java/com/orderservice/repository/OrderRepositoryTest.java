package com.orderservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.orderservice.model.Order;

/**
 * Classe de teste para OrderRepository.
 * 
 * Esta classe contém testes de unidade que validam o comportamento do repositório
 * de pedidos. Utiliza a configuração de teste do Spring Data JPA para interagir
 * com um banco de dados em memória e verificar as operações de persistência.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository; // Repositório de pedidos injetado para utilização nos testes.

    /**
     * Testa a funcionalidade de salvar e encontrar um pedido.
     * 
     * Este teste cria um novo pedido com status "PENDING" e valor de 100.0,
     * salva-o no repositório e, em seguida, recupera-o. O teste valida se o
     * ID do pedido salvo não é nulo e se o pedido encontrado possui o status
     * correto.
     */
    @Test
    void testSaveAndFindOrder() {
        Order order = new Order();
        order.setStatus("PENDING");
        order.setTotalValue(100.0);

        Order savedOrder = orderRepository.save(order);

        assertNotNull(savedOrder.getId());

        Order foundOrder = orderRepository.findById(savedOrder.getId()).orElse(null);

        assertNotNull(foundOrder);
        assertEquals("PENDING", foundOrder.getStatus());
    }
}