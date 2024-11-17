package com.orderservice.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Classe de requisição para criação de um novo pedido.
 * Esta classe contém informações sobre os produtos que compõem o pedido.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class OrderRequest {

    @NotEmpty(message = "A lista de produtos não pode ser vazia.")
    private List<@Valid ProductRequest> products;

    /**
     * Obtém a lista de produtos do pedido.
     *
     * @return A lista de produtos.
     */
    public List<ProductRequest> getProducts() {
        return products;
    }

    /**
     * Define a lista de produtos do pedido.
     *
     * @param products A lista de produtos a ser definida.
     */
    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }
}