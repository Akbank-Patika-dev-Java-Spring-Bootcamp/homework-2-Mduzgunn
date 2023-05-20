package com.md.hw2.controller.contract;

import com.md.hw2.dto.ProductDto;
import com.md.hw2.dto.requests.CreateProductRequest;
import com.md.hw2.dto.requests.UpdateProductRequest;

import java.util.List;

public interface ProductControllerContract {

    ProductDto save(CreateProductRequest createProductRequest);

    ProductDto update(Long id, UpdateProductRequest updateProductRequest);

    List<ProductDto> findAll();

    ProductDto findById(Long id);

    void delete(Long id);
}
