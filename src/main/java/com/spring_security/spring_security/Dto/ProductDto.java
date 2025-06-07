package com.spring_security.spring_security.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Product description is required")
    private String description;

    @NotNull(message = "Product price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Product quantity is required")
    @Positive(message = "Quantity must be positive")
    private Integer quantity;

    private String category;
}