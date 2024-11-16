package com.orderservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Classe de configuração de segurança da aplicação.
 * 
 * Esta classe define as regras de segurança, incluindo autenticação e autorização para proteger
 * os endpoints do serviço de pedidos. Aqui, a segurança básica HTTP é aplicada.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Desabilitar CSRF para permitir chamadas de API
        http
            .csrf().disable() // => Desabilita proteção CSRF
            .authorizeRequests()
            .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Permitir acesso à documentação
            .antMatchers("/orders/**").authenticated() // Exige autenticação para /orders
            .and()
            .httpBasic(); // Usar autenticação básica HTTP
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configurando o usuário em memória
        auth.inMemoryAuthentication()
            .withUser("orderservice").password("{noop}orderservicepsw").roles("USER"); // Configuração do usuário
    }
}