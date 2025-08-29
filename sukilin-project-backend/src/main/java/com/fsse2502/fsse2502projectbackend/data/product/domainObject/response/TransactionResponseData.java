package com.fsse2502.fsse2502projectbackend.data.product.domainObject.response;

import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionEntity;
import com.fsse2502.fsse2502projectbackend.data.product.entity.TransactionProductEntity;
import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import com.fsse2502.fsse2502projectbackend.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseData {
    private Integer tpid;
    private UserEntity user;
    private LocalDateTime transactionDate;
    private TransactionStatus transactionStatus;
    private BigDecimal amount;
    List<TransactionProductResponseData> transactionProductResponseDataList = new ArrayList<>();

    public TransactionResponseData(TransactionEntity transactionEntity) {
        this.tpid = transactionEntity.getTid();
        this.user = transactionEntity.getUserEntity();
        this.transactionDate = transactionEntity.getDateTime();
        this.transactionStatus = transactionEntity.getStatus();
        this.amount = transactionEntity.getTotal();

        setTransactionProductResponseDataList(transactionEntity);
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<TransactionProductResponseData> getTransactionProductResponseDataList() {
        return transactionProductResponseDataList;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTransactionProductResponseDataList(TransactionEntity transactionEntity) {
        for (TransactionProductEntity transactionProductEntity: transactionEntity.getTransactionProductEntityList()){
            transactionProductResponseDataList.add(
                    new TransactionProductResponseData(transactionProductEntity)
            );
        }
    }
}
