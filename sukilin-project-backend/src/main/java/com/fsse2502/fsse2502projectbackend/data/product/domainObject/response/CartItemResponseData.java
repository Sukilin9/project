package com.fsse2502.fsse2502projectbackend.data.product.domainObject.response;

import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.CartItemEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;

public class CartItemResponseData {
    private Integer cid;
    private ProductEntity productEntity;
    private UserEntity userEntity;
    private Integer quantity;

    public CartItemResponseData(CartItemEntity cartItemEntity) {
    this.cid = cartItemEntity.getCid();
    this.productEntity = cartItemEntity.getProduct();
    this.userEntity = cartItemEntity.getUser();
    this.quantity = cartItemEntity.getQuantity();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
