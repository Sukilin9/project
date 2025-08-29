package com.fsse2502.fsse2502projectbackend.data.user.entity;


import com.fsse2502.fsse2502projectbackend.data.product.entity.ProductEntity;
import jakarta.persistence.*;

@Entity
@Table( name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer cid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @JoinColumn(name = "quantity", nullable = false)
    private Integer quantity;

    public CartItemEntity() {
        this.quantity = 0;
    }

    public CartItemEntity(UserEntity user, ProductEntity product, Integer quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
