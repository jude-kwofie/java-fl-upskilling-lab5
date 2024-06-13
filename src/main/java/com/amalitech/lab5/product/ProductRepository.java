package com.amalitech.lab5.product;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository  extends ListCrudRepository<ProductModel, Long> {
}
