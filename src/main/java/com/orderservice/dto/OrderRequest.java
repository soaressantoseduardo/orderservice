package com.orderservice.dto;

import java.util.List;

/**
 * Classe de requisição para criação de um novo pedido.
 * 
 * Esta classe contém informações sobre os produtos que compõem o pedido.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class OrderRequest {
    private List<ProductRequest> products;

    // Getters e Setters

    /**
     * Obtém a lista de produtos do pedido.
     *
     * @return a lista de produtos
     */
    public List<ProductRequest> getProducts() {
        return products;
    }

    /**
     * Define a lista de produtos do pedido.
     *
     * @param products a lista de produtos a ser definida
     */
    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }
}