package com.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderservice.model.Product;

/**
 * Interface de repositório para a entidade Product.
 * 
 * Esta interface estende JpaRepository e permite operações de banco de dados 
 * para a entidade Product, como busca, salvamento e remoção de produtos.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Métodos adicionais para interação com produtos podem ser definidos aqui, se necessário.
}