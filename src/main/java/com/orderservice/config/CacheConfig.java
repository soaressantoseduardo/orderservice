package com.orderservice.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

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
	 @Bean
	    public CacheManager cacheManager(RedisConnectionFactory factory) {
	        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
	                .entryTtl(Duration.ofMinutes(10)); // Tempo de expiração de 10 minutos

	        return RedisCacheManager.builder(factory)
	                .cacheDefaults(config)
	                .build();
	    }
}
