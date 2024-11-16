package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.service.OrderService;

/**
 * Controlador REST para gerenciar pedidos.
 * 
 * Este controlador expõe os endpoints que permitem a criação e consulta
 * de pedidos. Utiliza o OrderService para processar a lógica relacionada
 * aos pedidos.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * Cria um novo pedido com os produtos fornecidos.
     *
     * @param orderRequest objeto que contém os detalhes do pedido
     * @return a resposta do pedido criado contendo o ID e o valor total do pedido
     */
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderResponse response = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Obtém os detalhes de um pedido específico.
     *
     * @param id o ID do pedido a ser buscado
     * @return detalhes do pedido encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        OrderResponse response = orderService.getOrderById(id);
        return ResponseEntity.ok(response);
    }
}