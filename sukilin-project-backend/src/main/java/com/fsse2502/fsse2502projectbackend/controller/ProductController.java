package com.fsse2502.fsse2502projectbackend.controller;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.dto.response.ProductByResponseDto;
import com.fsse2502.fsse2502projectbackend.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductByResponseDto> getAllProduct(){
        List<ProductByResponseDto> dtoList = new ArrayList<>();

        for (ProductResponseData data : productService.getAllProduct()) {
            dtoList.add(new ProductByResponseDto(data));
        }
        return dtoList;
    }

    @GetMapping("/{pid}")
    public ProductByResponseDto getByPid(@PathVariable Integer pid){
        return new ProductByResponseDto(
                productService.getByPid(pid)
        );
    }
}
