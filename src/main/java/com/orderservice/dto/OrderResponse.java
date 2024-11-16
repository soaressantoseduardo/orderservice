package com.orderservice.dto;

/**
 * Classe de resposta para um pedido.
 * 
 * Esta classe contém informações sobre um pedido que foi criado ou 
 * consultado, incluindo o ID do pedido, valor total e status.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class OrderResponse {
    private Long id;
    private Double totalValue;
    private String status;

    /**
     * Construtor da classe OrderResponse.
     *
     * @param id o ID do pedido
     * @param totalValue o valor total do pedido
     * @param status o status atual do pedido
     */
    public OrderResponse(Long id, Double totalValue, String status) {
        this.id = id;
        this.totalValue = totalValue;
        this.status = status;
    }

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
}