package com.fsse2502.fsse2502projectbackend.data.product.dto.response;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.TransactionProductResponseData;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
 private Integer tpid;
 private ProductByResponseDto product;
 private Integer quantity;
 private BigDecimal subtotal;


    public TransactionProductResponseDto(TransactionProductResponseData transactionProductResponseData) {
        this.product = new ProductByResponseDto(transactionProductResponseData);
        this.tpid = transactionProductResponseData.getTpid();
        this.quantity = transactionProductResponseData.getQuantity();
        this.subtotal = transactionProductResponseData.getPrice().multiply(
                new BigDecimal(
                        transactionProductResponseData.getQuantity()
                )
        );
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductByResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductByResponseDto product) {
        this.product = product;
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }
}

