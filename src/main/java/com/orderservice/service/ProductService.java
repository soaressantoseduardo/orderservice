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
 * Esta classe contém a lógica de negócios relacionada aos produtos, incluindo
 * a criação, recuperação e listagem dos produtos disponíveis.
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
     * @param productRequest Objeto que contém os detalhes do produto.
     * @return O produto criado.
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
     * @param id O ID do produto a ser buscado.
     * @return O produto encontrado.
     * @throws EntityNotFoundException Se o produto não for encontrado.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    }

    /**
     * Obtém todos os produtos.
     *
     * @return Uma lista de produtos.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}