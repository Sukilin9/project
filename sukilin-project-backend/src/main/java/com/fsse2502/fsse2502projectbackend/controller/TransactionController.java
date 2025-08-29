package com.fsse2502.fsse2502projectbackend.controller;

import com.fsse2502.fsse2502projectbackend.data.product.dto.response.TransactionResponseDto;
import com.fsse2502.fsse2502projectbackend.service.TransactionService;
import com.fsse2502.fsse2502projectbackend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping("")
    public TransactionResponseDto createTransaction(JwtAuthenticationToken jwtAuthenticationToken){
        return new TransactionResponseDto(
                transactionService.prepareTransaction(JwtUtil.getFirebaseUserData(jwtAuthenticationToken))
        );
    }

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransaction(JwtAuthenticationToken jwtAuthenticationToken,
                                                 @PathVariable Integer tid){
        return new TransactionResponseDto(
                transactionService.getTransactionByTid(JwtUtil.getFirebaseUserData(jwtAuthenticationToken),tid)
        );
    }

    @PatchMapping("/{tid}/payment")
    public void payTransaction(JwtAuthenticationToken jwtAuthenticationToken,
                               @PathVariable Integer tid){
        transactionService.processTransaction(JwtUtil.getFirebaseUserData(jwtAuthenticationToken),tid);
    }

    @PatchMapping("/{tid}/success")
    public TransactionResponseDto finishTransaction(JwtAuthenticationToken jwtAuthenticationToken,
                                                    @PathVariable Integer tid){
        return new TransactionResponseDto(
                transactionService.finishTransaction(JwtUtil.getFirebaseUserData(jwtAuthenticationToken), tid)
        );
    }
}
