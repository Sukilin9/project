package com.fsse2502.fsse2502projectbackend.repository;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity, Integer> {
    List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity);
}
