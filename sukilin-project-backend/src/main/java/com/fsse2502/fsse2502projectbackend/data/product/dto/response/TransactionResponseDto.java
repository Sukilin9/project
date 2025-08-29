package com.fsse2502.fsse2502projectbackend.data.product.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.TransactionProductResponseData;
import com.fsse2502.fsse2502projectbackend.data.product.domainObject.response.TransactionResponseData;
import com.fsse2502.fsse2502projectbackend.status.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    private Integer id;
    private Integer buyerUid;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime transactionDate;
    private TransactionStatus status;
    private BigDecimal total;

    @JsonProperty("Items")
    private List<TransactionProductResponseDto> transactionProductResponseDto = new ArrayList<>();

    public TransactionResponseDto(TransactionResponseData transactionResponseData) {
        this.total = transactionResponseData.getAmount();
        this.status = transactionResponseData.getTransactionStatus();
        this.transactionDate = transactionResponseData.getTransactionDate();
        this.buyerUid = transactionResponseData.getUser().getUid();
        this.id = transactionResponseData.getTpid();
        for (TransactionProductResponseData transactionProductResponseData: transactionResponseData.getTransactionProductResponseDataList()){
            this.transactionProductResponseDto.add
                    (new TransactionProductResponseDto(
                            transactionProductResponseData));
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
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

    public List<TransactionProductResponseDto> getTransactionProductResponseDto() {
        return transactionProductResponseDto;
    }

    public void setTransactionProductResponseDto(List<TransactionProductResponseDto> transactionProductResponseDto) {
        this.transactionProductResponseDto = transactionProductResponseDto;
    }
}


