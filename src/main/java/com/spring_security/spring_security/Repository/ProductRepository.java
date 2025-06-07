package com.spring_security.spring_security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security.spring_security.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Add custom query methods if needed
}