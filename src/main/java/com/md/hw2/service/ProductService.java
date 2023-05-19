package com.md.hw2.service;

import com.md.hw2.base.service.BaseService;
import com.md.hw2.dto.ProductDto;
import com.md.hw2.dto.requests.CreateProductRequest;
import com.md.hw2.dto.requests.UpdateProductRequest;
import com.md.hw2.entity.Product;
import com.md.hw2.mapper.ProductMapper;
import com.md.hw2.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {

    private final ProductMapper productMapper;

    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        super(repository);
        this.productMapper = productMapper;
    }

    public ProductDto getProductById(Long id) {
        return productMapper.productToProductDto(this.findByIdWithControl(id));
    }

    public List<ProductDto> getAllProductDtoList() {
        return productMapper.convertToProductDtoList(this.findAll());
    }

    public ProductDto createProduct(CreateProductRequest createProductRequest) {
        Product product = productMapper.createProductRequestToProduct(createProductRequest);
        return productMapper.productToProductDto(this.save(product));
    }

    public ProductDto updateProduct(Long id, UpdateProductRequest updateProductRequest) {
        Product product = this.findByIdWithControl(id);
        product.setPrice(updateProductRequest.price());

        return productMapper.productToProductDto(this.save(product));
    }

    public String deleteProductById(Long id) {
        getProductById(id);
        this.delete(id);
        return "Product deleted successfully with id " + id;
    }

}
