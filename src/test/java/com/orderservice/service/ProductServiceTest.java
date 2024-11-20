package com.orderservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.orderservice.dto.ProductRequest;
import com.orderservice.model.Product;
import com.orderservice.repository.ProductRepository;
import com.orderservice.exception.EntityNotFoundException;

/**
 * Classe de teste para ProductService.
 * 
 * Esta classe contém testes unitários que validam o comportamento dos métodos
 * na classe ProductService. Usamos Mockito para simular interações com o
 * repositório de produtos, permitindo que a lógica em ProductService seja
 * testada isoladamente.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
class ProductServiceTest {

    @InjectMocks
    private ProductService productService; // Classe de serviço sob teste.

    @Mock
    private ProductRepository productRepository; // Repositório simulado.

    /**
     * Configura os mocks antes da execução de cada método de teste.
     * Inicializa os mocks usando Mockito para garantir um ambiente de teste
     * controlado.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testa a criação de um novo produto.
     * 
     * Este teste verifica se o método createProduct está salvando o produto
     * corretamente no repositório e se o ID do produto criado é igual ao esperado.
     * 
     * @throws Exception em caso de falhas na execução do teste.
     */
    @Test
    void testCreateProduct() {
        ProductRequest productRequest = new ProductRequest("Produto Teste", 20.0);
        Product product = new Product();
        product.setId(1L); // Simulando um ID gerado.

        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(productRequest);

        assertNotNull(createdProduct);
        assertEquals(1L, createdProduct.getId());
        verify(productRepository, times(1)).save(any(Product.class));
    }

    /**
     * Testa a recuperação de um produto por ID quando o produto não existe.
     * 
     * Este teste verifica se o método getProductById lança uma exceção
     * EntityNotFoundException quando um ID inválido é passado, garantindo que
     * o fluxo de erro seja tratado corretamente.
     * 
     * @throws Exception em caso de falhas na execução do teste.
     */
    @Test
    void testGetProductByIdProductNotFound() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            productService.getProductById(1L);
        });

        verify(productRepository, times(1)).findById(1L);
    }
}