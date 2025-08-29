package com.fsse2502.fsse2502projectbackend.exception.product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotExist extends RuntimeException{
    public ProductNotExist(String pid) {
        super("product not found: pid= " + pid );
    }
}
