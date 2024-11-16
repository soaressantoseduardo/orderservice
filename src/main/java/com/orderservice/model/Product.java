package com.orderservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

/**
 * Entidade que representa um produto no pedido.
 * 
 * Esta classe modela as informações de um produto, incluindo nome e preço.
 * É mapeada para a tabela de produtos no banco de dados, sendo associada
 * a um pedido específico.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    // Getters e Setters

    /**
     * Obtém o ID do produto.
     *
     * @return o ID do produto
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     *
     * @param id o ID do produto a ser definido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     *
     * @return o nome do produto
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do produto.
     *
     * @param name o nome do produto a ser definido
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return o preço do produto
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Define o preço do produto.
     *
     * @param price o preço do produto a ser definido
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Obtém o pedido associado ao produto.
     *
     * @return o pedido associado
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Define o pedido associado ao produto.
     *
     * @param order o pedido a ser associado
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
