package com.md.hw2.controller;

import com.md.hw2.base.RestResponse;
import com.md.hw2.controller.contract.ProductControllerContract;
import com.md.hw2.dto.ProductDto;
import com.md.hw2.dto.requests.CreateProductRequest;
import com.md.hw2.dto.requests.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<RestResponse<ProductDto>> save(@RequestBody CreateProductRequest createProductRequest) {
        var productDto = productControllerContract.save(createProductRequest);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDto>> update(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest) {
        var productDto = productControllerContract.update(id, updateProductRequest);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDto>> findById(@PathVariable Long id) {
        var productDto = productControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(productDto));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDto>>> findAll() {
        var productDtoList = productControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(productDtoList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<String>> delete(@PathVariable Long id) {
        productControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.of("Deleted by " + id));
    }

}
