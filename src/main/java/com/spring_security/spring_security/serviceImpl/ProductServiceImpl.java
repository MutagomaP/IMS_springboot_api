package com.spring_security.spring_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security.spring_security.Dto.ProductDto;
import com.spring_security.spring_security.Models.Product;
import com.spring_security.spring_security.Repository.ProductRepository;
import com.spring_security.spring_security.Service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product();
        mapDtoToProduct(productDto, product);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));

        mapDtoToProduct(productDto, product);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new EntityNotFoundException("Product not found with id: " + productId);
        }
        productRepository.deleteById(productId);
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + productId));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    private void mapDtoToProduct(ProductDto dto, Product product) {
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        product.setCategory(dto.getCategory());
    }
}