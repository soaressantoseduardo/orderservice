package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.dto.ProductRequest;
import com.orderservice.exception.EntityNotFoundException;
import com.orderservice.model.Order;
import com.orderservice.model.Product;
import com.orderservice.repository.OrderRepository;
import com.orderservice.repository.ProductRepository;
import com.orderservice.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Serviço para gerenciamento de pedidos.
 * 
 * Esta classe contém a lógica de negócios relacionada a pedidos, incluindo
 * a criação e a recuperação de detalhes sobre pedidos específicos.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Cria um novo pedido baseado na solicitação recebida.
     *
     * @param orderRequest objeto que contém os detalhes dos produtos do pedido
     * @return a resposta do pedido criado contendo o ID, valor total e status
     */
    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus(Constants.STATUS_PENDING); // Usando constante
        List<Product> products = new ArrayList<>();
        Double totalValue = 0.0;

        for (ProductRequest productRequest : orderRequest.getProducts()) {
            Product product = new Product();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setOrder(order);
            totalValue += product.getPrice();
            products.add(product);
        }

        order.setProducts(products);
        order.setTotalValue(totalValue);
        
        orderRepository.save(order);
        return new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus());
    }

    /**
     * Obtém os detalhes de um pedido pelo ID.
     *
     * @param id o ID do pedido a ser buscado
     * @return a resposta do pedido contendo detalhes como ID, valor total e status
     * @throws EntityNotFoundException se o pedido não for encontrado
     */
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(order -> new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus()))
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    /**
     * Obtém todos os pedidos.
     *
     * @return uma lista de respostas de pedidos
     */
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus()))
                .collect(Collectors.toList());
    }
}
