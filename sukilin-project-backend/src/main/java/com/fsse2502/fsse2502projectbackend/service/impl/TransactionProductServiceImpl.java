package com.fsse2502.fsse2502projectbackend.service.impl;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionProductEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.CartItemEntity;
import com.fsse2502.fsse2502projectbackend.repository.TransactionProductRepository;
import com.fsse2502.fsse2502projectbackend.service.CartItemService;
import com.fsse2502.fsse2502projectbackend.service.TransactionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private CartItemService cartItemService;
    private TransactionProductRepository transactionProductRepository;

    @Autowired
    public TransactionProductServiceImpl(CartItemService cartItemService,
                                         TransactionProductRepository transactionProductRepository) {
        this.cartItemService = cartItemService;
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public List<TransactionProductEntity> createTransactionProductList(TransactionEntity transactionEntity) {

        List<CartItemEntity> cartItemEntityList = cartItemService.getCartItemListByUserEntity(transactionEntity.getUserEntity());
        List<TransactionProductEntity> transactionProductEntities = new ArrayList<>();

        for (CartItemEntity cartItemEntity : cartItemEntityList) {
            TransactionProductEntity transactionProductEntity = new TransactionProductEntity(transactionEntity, cartItemEntity);
            transactionProductEntity = transactionProductRepository.save(transactionProductEntity);
            transactionProductEntities.add(transactionProductEntity);
        }
        return transactionProductEntities;
    }

}