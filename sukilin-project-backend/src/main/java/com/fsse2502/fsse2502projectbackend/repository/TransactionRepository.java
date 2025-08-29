package com.fsse2502.fsse2502projectbackend.repository;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer> {
    TransactionEntity findTransactionEntityByTid(Integer tid);
    TransactionEntity findTransactionEntityByTidAndUserEntity(Integer tid, UserEntity userEntity);
}
