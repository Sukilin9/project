package com.fsse2502.fsse2502projectbackend.service;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import com.fsse2502.fsse2502projectbackend.exception.product.ProductNotExist;

import java.util.List;

public interface ProductService {
    List<ProductResponseData> getAllProduct();

    ProductResponseData getByPid(Integer pid);

    ProductEntity getProductEntityById(Integer pid);

    ProductEntity getEntityByPid(Integer pid);

    boolean deductStock(Integer pid, Integer quantity);
}
