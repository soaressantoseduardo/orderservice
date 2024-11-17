package com.orderservice.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

/**
 * Classe de requisição para um produto em um pedido.
 * Esta classe contém informações sobre um produto, incluindo seu nome e preço,
 * e é utilizada na criação de um pedido.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class ProductRequest {
    
    @NotBlank(message = "O nome do produto não pode estar vazio.")
    private String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "O preço do produto deve ser maior que zero.")
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