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


}
