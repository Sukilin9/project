package com.fsse2502.fsse2502projectbackend.data.product.entity;

import com.fsse2502.fsse2502projectbackend.data.user.entity.UserEntity;
import com.fsse2502.fsse2502projectbackend.status.TransactionStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")

public class TransactionEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @Column(name ="date_time", nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TransactionStatus status;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @OneToMany(mappedBy = "transaction")
    private List<TransactionProductEntity> transactionProductEntityList = new ArrayList<>();

    public TransactionEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
        this.dateTime = LocalDateTime.now();
        this.status = TransactionStatus.PREPARED;
        this.total = BigDecimal.ZERO;
    }

    public TransactionEntity() {

    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductEntity> getTransactionProductEntityList() {
        return transactionProductEntityList;
    }

    public void setTransactionProductEntityList(List<TransactionProductEntity> transactionProductEntityList) {
        this.transactionProductEntityList = transactionProductEntityList;
    }
}
