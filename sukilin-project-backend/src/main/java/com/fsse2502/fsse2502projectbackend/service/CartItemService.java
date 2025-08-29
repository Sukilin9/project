package com.fsse2502.fsse2502projectbackend.service;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.CartItemResponseData;
import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.data.user.entity.CartItemEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface CartItemService {

    void putCartItem(FirebaseUserData firebaseUserData, Integer pid, @Positive Integer quantity);

    List<CartItemResponseData> getCartItemList(FirebaseUserData firebaseUserData);

    CartItemResponseData updateItem(int pid, int quantity, FirebaseUserData firebaseUserData);

    @Transactional
    void deleteItem(Integer pid, FirebaseUserData firebaseUserData);

    void emptyCart(UserEntity userEntity);

    List<CartItemEntity> getCartItemListByUserEntity(UserEntity userEntity);
}
