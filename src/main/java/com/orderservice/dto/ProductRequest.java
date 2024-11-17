package com.orderservice.dto;

/**
 * Classe de requisição para um produto em um pedido.
 * Esta classe contém informações sobre um produto, incluindo seu nome e preço,
 * e é utilizada na criação de um pedido.
 */
public class ProductRequest {
    private String name;
    private Double price;

    /**
     * Obtém o nome do produto.
     *
     * @return O nome do produto.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do produto.
     *
     * @param name O nome do produto a ser definido.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o preço do produto.
     *
     * @return O preço do produto.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Define o preço do produto.
     *
     * @param price O preço do produto a ser definido.
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}