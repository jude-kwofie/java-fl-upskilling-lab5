package com.amalitech.lab5.product;

import com.amalitech.lab5.product.dto.ProductRequestDTO;
import com.amalitech.lab5.product.dto.ProductResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO createProduct(ProductRequestDTO product);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productDetails);

    void deleteProduct(Long id);
}
