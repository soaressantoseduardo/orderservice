package com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
}