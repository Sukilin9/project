package com.fsse2502.fsse2502projectbackend.service.impl;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.CartItemResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;
import com.fsse2502.fsse2502projectbackend.data.user.entity.CartItemEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import com.fsse2502.fsse2502projectbackend.exception.product.ProductNotExist;
import com.fsse2502.fsse2502projectbackend.repository.CartItemRepository;
import com.fsse2502.fsse2502projectbackend.service.CartItemService;
import com.fsse2502.fsse2502projectbackend.service.ProductService;
import com.fsse2502.fsse2502projectbackend.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public void putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        UserEntity userEntity = userService.getEntityByEmail(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()) {
            cartItemEntity = existingCartItem.get();
            cartItemEntity.setQuantity(cartItemEntity.getQuantity() + quantity);
        } else {
            cartItemEntity = new CartItemEntity(userEntity, productEntity, quantity);
        }
        cartItemRepository.save(cartItemEntity);
    }

    @Override
    public List<CartItemResponseData> getCartItemList(FirebaseUserData firebaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemRepository.findByUser(userEntity)) {
            cartItemResponseDataList.add(
                    new CartItemResponseData(cartItemEntity)
            );
        }

        return cartItemResponseDataList;
    }

    @Override
    public CartItemResponseData updateItem(int pid, int quantity, FirebaseUserData firebaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);

        if (cartItemRepository.findByUserAndProduct(userEntity, productEntity).isPresent()) {
            CartItemEntity existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity).get();
            existingCartItem.setQuantity(quantity);
            cartItemRepository.save(existingCartItem);
            return new CartItemResponseData(existingCartItem);
        }
        throw new ProductNotExist("error");
    }

    @Transactional
    @Override
    public void deleteItem(Integer pid, FirebaseUserData firebaseUserData) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        ProductEntity productEntity = productService.getProductEntityById(pid);
        Optional<CartItemEntity> existingCartItem = cartItemRepository.findByUserAndProduct(userEntity, productEntity);

        CartItemEntity cartItemEntity;
        if (existingCartItem.isPresent()) {
            cartItemEntity = existingCartItem.get();
            cartItemRepository.delete(cartItemEntity);

        } else {
            throw new ProductNotExist("Product Not Exist");
        }
    }

    @Transactional
    @Override
    public void emptyCart(UserEntity userEntity){
        cartItemRepository.deleteAllByUser(userEntity);
    }

    @Override
    public List<CartItemEntity> getCartItemListByUserEntity(UserEntity userEntity){
        return  cartItemRepository.findByUser(userEntity);
    }
}