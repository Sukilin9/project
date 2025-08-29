package com.fsse2502.fsse2502projectbackend.service;

import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.TransactionResponseData;
import com.fsse2502.fsse2502projectbackend.data.user.domainObject.request.FirebaseUserData;

public interface TransactionService {
    TransactionResponseData prepareTransaction(FirebaseUserData firebaseUserData);

    TransactionResponseData getTransactionByTid(FirebaseUserData firebaseUserData, Integer tid);

    void processTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid);
}
