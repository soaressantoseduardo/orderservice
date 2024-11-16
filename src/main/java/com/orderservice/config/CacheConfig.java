package com.orderservice.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Classe de configuração de cache para a aplicação.
 * 
 * Esta classe habilita o uso de cache para armazenar resultados de operações repetitivas,
 * melhorando o desempenho da aplicação, especialmente em consultas a dados que não mudam com frequência.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Configuration
@EnableCaching
public class CacheConfig {
    // Configurações adicionais para cache podem ser adicionadas aqui se necessário.
}
