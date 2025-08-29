package com.fsse2502.fsse2502projectbackend.data.product.domainObject.response;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionProductEntity;

import java.math.BigDecimal;

public class TransactionProductResponseData {
    private Integer tpid;
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer Stock;
    private String description;
    private Integer quantity;

    public TransactionProductResponseData(TransactionProductEntity transactionProductEntity) {
        this.tpid = transactionProductEntity.getTpid();
        this.pid = transactionProductEntity.getPid();
        this.name = transactionProductEntity.getName();
        this.imageUrl = transactionProductEntity.getImageUrl();
        this.price = transactionProductEntity.getPrice();
        this.Stock = transactionProductEntity.getStock();
        this.description = transactionProductEntity.getDescription();
        this.quantity = transactionProductEntity.getQuantity();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
