package com.md.hw2.mapper;

import com.md.hw2.dto.ProductDto;
import com.md.hw2.dto.requests.CreateProductRequest;
import com.md.hw2.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product createProductRequestToProduct(CreateProductRequest createProductRequest);

    ProductDto productToProductDto(Product product);

    List<ProductDto> convertToProductDtoList(List<Product> productList);
}
