package com.md.hw2.controller.contract.impl;

import com.md.hw2.controller.contract.ProductControllerContract;
import com.md.hw2.dto.ProductDto;
import com.md.hw2.dto.requests.CreateProductRequest;
import com.md.hw2.dto.requests.UpdateProductRequest;
import com.md.hw2.entity.Product;
import com.md.hw2.mapper.ProductMapper;
import com.md.hw2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductControllerContactImpl implements ProductControllerContract {

    private final ProductService productService;

    @Override
    public ProductDto save(CreateProductRequest createProductRequest) {
        Product product = ProductMapper.INSTANCE.createProductRequestToProduct(createProductRequest);
        product = productService.save(product);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public ProductDto update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productService.findByIdWithControl(id);
        product.setPrice(updateProductRequest.price());
        product = productService.save(product);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productService.findAll();
        return ProductMapper.INSTANCE.convertToProductDtoList(productList);
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productService.findByIdWithControl(id);
        return ProductMapper.INSTANCE.productToProductDto(product);
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }
}
