package com.amalitech.lab5.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true) // Enables the fluent API style
public class ProductRequestDTO {

    @NotNull(message = "Product name cannot be null.")
    @NotBlank(message = "Name is mandatory.")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters.")
    private String name;

    @NotNull(message = "Product description cannot be null.")
    @NotBlank(message = "Description is mandatory.")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters.")
    private String description;

    @NotNull(message = "Price is mandatory.")
    @Positive(message = "Price must be positive.")
    private Double price;
}

