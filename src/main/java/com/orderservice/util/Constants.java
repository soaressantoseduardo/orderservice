package com.orderservice.util;

/**
 * Classe utilitária para armazenar constantes utilizadas na aplicação.
 * 
 * Esta classe contém constantes que são usadas em todo o projeto para evitar
 * a duplicação de strings e valores fixos em várias partes do código.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
public class Constants {
    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_COMPLETED = "COMPLETED";
    public static final String STATUS_CANCELLED = "CANCELLED";

    private Constants() {
        // Evita a instanciação
    }
}