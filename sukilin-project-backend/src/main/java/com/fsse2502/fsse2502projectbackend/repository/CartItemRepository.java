package com.fsse2502.fsse2502projectbackend.repository;

import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.data.user.entity.CartItemEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends CrudRepository<CartItemEntity, Integer> {

    Optional<CartItemEntity> findByUserAndProduct(UserEntity userEntity, ProductEntity productEntity);

    List<CartItemEntity> findByUser(UserEntity user);

    void deleteAllByUser(UserEntity user);
}
