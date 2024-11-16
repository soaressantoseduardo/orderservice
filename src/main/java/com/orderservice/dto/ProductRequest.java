package com.orderservice.dto;

/**
 * Classe de requisição para um produto em um pedido.
 * 
 * Esta classe contém informações sobre um produto, incluindo seu nome e preço,
 * e é utilizada na criação de um pedido.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class ProductRequest {
    private String name;
    private Double price;

    // Getters e Setters

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
     * @param/**
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
}
