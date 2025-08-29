package com.fsse2502.fsse2502projectbackend.data.product.dto.response;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.ProductResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.TransactionProductResponseData;

import java.math.BigDecimal;



public class ProductByResponseDto {
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;

    public ProductByResponseDto(ProductResponseData productResponseData) {
        this.pid = productResponseData.getPid();
        this.name = productResponseData.getName();
        this.description = productResponseData.getDescription();
        this.imageUrl = productResponseData.getImageUrl();
        this.price = productResponseData.getPrice();
        this.stock = productResponseData.getStock();
    }

    public ProductByResponseDto(TransactionProductResponseData transactionProductResponseData ) {
            this.pid = transactionProductResponseData.getPid();
            this.name = transactionProductResponseData.getName();
            this.description = transactionProductResponseData.getDescription();
            this.imageUrl = transactionProductResponseData.getImageUrl();
            this.price = transactionProductResponseData.getPrice();
            this.stock = transactionProductResponseData.getStock();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}


