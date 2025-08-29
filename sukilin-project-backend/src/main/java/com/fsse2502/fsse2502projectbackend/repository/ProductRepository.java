package com.fsse2502.fsse2502projectbackend.repository;

import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository <ProductEntity, Integer > {
}
