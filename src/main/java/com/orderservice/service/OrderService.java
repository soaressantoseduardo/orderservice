package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.dto.ProductRequest;
import com.orderservice.exception.DuplicatedOrderException;
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
 * Esta classe contém a lógica de negócios relacionada a pedidos, incluindo
 * a criação e a recuperação de informações sobre pedidos específicos.
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
     * @param orderRequest Objeto que contém os detalhes dos produtos do pedido.
     * @return A resposta do pedido criado contendo o ID, valor total e status.
     * @throws DuplicatedOrderException Se um pedido duplicado for detectado.
     */
    @CacheEvict(value = "orders", allEntries = true)
    public OrderResponse createOrder(OrderRequest orderRequest) {
        List<Product> products = new ArrayList<>();
        Double totalValue = 0.0;

        for (ProductRequest productRequest : orderRequest.getProducts()) {
            totalValue += productRequest.getPrice();
        }

        // Verifica duplicado assumindo que produtos já existem no banco
        if (orderRepository.existsByTotalValueAndProductsIn(totalValue, products)) {
            throw new DuplicatedOrderException("Um pedido equivalente já existe.");
        }

        Order order = new Order();
        order.setStatus("PENDING");
        order.setTotalValue(totalValue);

        // Associar produtos salvando-os na transação
        for (ProductRequest productRequest : orderRequest.getProducts()) {
            Product product = new Product();
            product.setName(productRequest.getName());
            product.setPrice(productRequest.getPrice());
            product.setOrder(order); // Realiza a associação aqui

            products.add(product);
        }

        // Finalmente, salvar todo o pedido e seus produtos atrelados
        order.setProducts(products);
        orderRepository.save(order);

        return new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus());
    }

    /**
     * Obtém os detalhes de um pedido pelo ID, utilizando cache.
     *
     * @param id O ID do pedido a ser buscado.
     * @return A resposta do pedido contendo detalhes como ID, valor total e status.
     * @throws EntityNotFoundException Se o pedido não for encontrado.
     */
    @Cacheable(value = "orders", key = "#id")
    public OrderResponse getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(order -> new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus()))
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    }

    /**
     * Obtém todos os pedidos com cache.
     *
     * @return Uma lista de respostas de pedidos.
     */
    @Cacheable(value = "orders")
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus()))
                .collect(Collectors.toList());
    }
    
    /**
     * Obtém todos os pedidos com suporte à paginação.
     *
     * @param page Número da página a ser recuperada.
     * @param size Tamanho da página (número de resultados por página).
     * @return Uma lista paginada de respostas de pedidos.
     */
    public Page<OrderResponse> getAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return orderRepository.findAll(pageable).map(order -> new OrderResponse(order.getId(), order.getTotalValue(), order.getStatus()));
    }
}