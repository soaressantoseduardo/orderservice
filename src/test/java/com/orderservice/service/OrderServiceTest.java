package com.orderservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.dto.ProductRequest;
import com.orderservice.exception.EntityNotFoundException;
import com.orderservice.model.Order;
import com.orderservice.repository.OrderRepository;
import com.orderservice.repository.ProductRepository;

/**
 * Classe de teste para OrderService.
 * 
 * Esta classe contém testes unitários que validam o comportamento dos métodos
 * na classe OrderService. Utiliza Mockito para simular interações com repositórios,
 * garantindo que a lógica em OrderService possa ser testada isoladamente sem
 * acessos a bancos de dados reais.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
class OrderServiceTest {

    @InjectMocks
    private OrderService orderService; // Classe sob teste.

    @Mock
    private OrderRepository orderRepository; // Repositório de pedidos mockado.

    @Mock
    private ProductRepository productRepository; // Repositório de produtos mockado.

    /**
     * Configura o ambiente de teste antes da execução de cada método de teste.
     * Inicializa os mocks utilizando Mockito.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa a criação de um novo pedido.
     * 
     * Este teste simula a criação de um pedido usando um Produto e valida se
     * o pedido é salvo corretamente e se o ID e os dados retornados estão corretos.
     */
    @Test
    void testCreateOrder() {
        // Arrange
        ProductRequest productRequest = new ProductRequest("Sample Product", 10.0);
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setProducts(Collections.singletonList(productRequest));

        // Simula o comportamento do "save" do OrderRepository
        when(orderRepository.save(any(Order.class))).thenAnswer(invocation -> {
            Order order = invocation.getArgument(0);
            order.setId(1L); // Simula a atribuição do ID
            return order;
        });

        // Act
        OrderResponse orderResponse = orderService.createOrder(orderRequest);

        // Assert
        assertNotNull(orderResponse);
        assertEquals(1L, orderResponse.getId());
        assertEquals(10.0, orderResponse.getTotalValue());
        assertEquals("PENDING", orderResponse.getStatus());
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    /**
     * Testa a recuperação de um pedido pelo ID quando o pedido não existe.
     * 
     * Este teste verifica se uma exceção EntityNotFoundException é lançada
     * quando se tenta buscar um pedido que não está presente no repositório.
     */
    @Test
    void testGetOrderByIdOrderNotFound() {
        // Arrange
        Long id = 1L;
        when(orderRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(EntityNotFoundException.class, () -> {
            orderService.getOrderById(id);
        });

        verify(orderRepository, times(1)).findById(id);
    }
}