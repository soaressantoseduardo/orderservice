package com.orderservice.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * Entidade que representa um pedido na aplicação.
 * 
 * Esta classe contém informações sobre um pedido, incluindo produtos
 * associados e o valor total. É mapeada para a tabela de pedidos no banco
 * de dados.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
    private Double totalValue;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;

    // Getters e Setters

    /**
     * Obtém o ID do pedido.
     *
     * @return o ID do pedido
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do pedido.
     *
     * @param id o ID do pedido a ser definido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o status do pedido.
     *
     * @return o status do pedido
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status do pedido.
     *
     * @param status o status do pedido a ser definido
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtém o valor total do pedido.
     *
     * @return o valor total do pedido
     */
    public Double getTotalValue() {
        return totalValue;
    }

    /**
     * Define o valor total do pedido.
     *
     * @param totalValue o valor total do pedido a ser definido
     */
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * Obtém a lista de produtos associados ao pedido.
     *
     * @return a lista de produtos
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Define a lista de produtos associados ao pedido.
     *
     * @param products a lista de produtos a ser definida
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}