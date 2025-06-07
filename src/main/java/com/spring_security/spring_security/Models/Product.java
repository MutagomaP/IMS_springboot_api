package com.spring_security.spring_security.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(name = "product_name", length = 255, nullable = false)
    private String productName;

    @NotBlank(message = "Product description is required")
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Product price is required")
    @Positive(message = "Price must be positive")
    @Column(name = "price", nullable = false)
    private Double price;

    @NotNull(message = "Product quantity is required")
    @Positive(message = "Quantity must be positive")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "category", length = 100)
    private String category;
}