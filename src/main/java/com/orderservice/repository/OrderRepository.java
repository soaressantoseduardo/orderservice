package com.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orderservice.model.Product;

import com.orderservice.model.Order;

/**
 * Interface de repositório para a entidade Order.
 * 
 * Esta interface estende JpaRepository e permite operações de banco de dados 
 * para a entidade Order, como busca, salvamento e remoção de pedidos.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    /**
     * Verifica se um pedido existe pelo ID fornecido.
     *
     * @param id o ID do pedido a ser verificado
     * @return true se o pedido existir, caso contrário false
     */
    boolean existsById(Long id);
    
    /**
     * Verifica se um pedido existe com base no valor total e na lista de produtos especificados.
     *
     * @param totalValue O valor total do pedido.
     * @param products A lista de produtos do pedido.
     * @return true se um pedido duplicado existir, caso contrário false.
     */
    boolean existsByTotalValueAndProductsIn(Double totalValue, List<Product> products);
}