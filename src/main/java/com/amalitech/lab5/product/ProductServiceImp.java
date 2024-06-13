package com.amalitech.lab5.product;

import com.amalitech.lab5.exeception.ResourceNotFoundException;
import com.amalitech.lab5.product.dto.ProductRequestDTO;
import com.amalitech.lab5.product.dto.ProductResponseDTO;
import org.modelmapper.Condition;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp  implements ProductService{
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ModelMapper modelMapper,ProductRepository productRepository){
        this.modelMapper=modelMapper;
        this.productRepository=productRepository;
    }
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return this.productRepository.findAll()
                .stream()
                .map(product->modelMapper.map(product,ProductResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

        return this.modelMapper.map(product, ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        ProductModel productModel = this.modelMapper.map(productRequestDTO, ProductModel.class);
        System.out.println(productModel);
        System.out.println("uuuuuuuuuuuuuuuu");

        ProductModel productCreated = this.productRepository.save(productModel);

        return modelMapper.map(productCreated, ProductResponseDTO.class);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        ProductModel product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        Condition<?, ?> originalCondition = modelMapper.getConfiguration().getPropertyCondition();

        try {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(productRequestDTO, product);
            ProductModel updatedProduct = productRepository.save(product);

            return modelMapper.map(updatedProduct, ProductResponseDTO.class);

        } finally {
            modelMapper.getConfiguration().setPropertyCondition(originalCondition);
        }

        }
    @Override
    public void deleteProduct(Long id) {

        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found for this id :: " + id);
        }

        productRepository.deleteById(id);

    }
}
