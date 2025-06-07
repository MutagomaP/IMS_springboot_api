package com.spring_security.spring_security.Service;

import java.util.List;

import com.spring_security.spring_security.Dto.ProductDto;
import com.spring_security.spring_security.Models.Product;

public interface ProductService {
    Product createProduct(ProductDto productDto);

    Product updateProduct(Long productId, ProductDto productDto);

    void deleteProduct(Long productId);

    Product getProduct(Long productId);

    List<Product> getAllProducts();
}