package com.example.demo.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "transaction-service", url = "http://localhost:8081")
public interface TransactionServiceProxy {
    @PostMapping("/transactions")
    void logTransaction(
            @RequestParam("clientId") Long clientId,
            @RequestParam("previousBalance") Float previousBalance,
            @RequestParam("newBalance") Float newBalance
    );
}
