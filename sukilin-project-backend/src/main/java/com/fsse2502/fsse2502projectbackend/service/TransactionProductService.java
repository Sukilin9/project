package com.fsse2502.fsse2502projectbackend.service;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {

    List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity);
}
