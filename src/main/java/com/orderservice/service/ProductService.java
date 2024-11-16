package com.orderservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.dto.ProductRequest;
import com.orderservice.model.Product;
import com.orderservice.repository.ProductRepository;

import com.orderservice.exception.EntityNotFoundException;
import java.util.List;

/**
 * Serviço para gerenciamento de produtos.
 * 
 * Esta classe contém a lógica de negócios relacionada aos produtos, incluindo
 * a criação, a recuperação e a listagem dos produtos disponíveis.
 * 
 * Autor: Eduardo Soares Santos
 * Email: soaressantoseduardo@gmail.com
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Cria um novo produto baseado na solicitação.
     *
     * @param productRequest objeto que contém os detalhes do produto
     * @return o produto criado
     */
    public Product createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        return productRepository.save(product);
    }

    /**
     * Obtém um produto pelo ID.
     *
     * @param id o ID do produto a ser buscado
     * @return o produto encontrado
     * @throws EntityNotFoundException se o produto não for encontrado
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    /**
     * Obtém todos os produtos.
     *
     * @return uma lista de produtos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}