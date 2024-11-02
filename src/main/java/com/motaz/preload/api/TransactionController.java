package com.motaz.preload.api;

import com.motaz.preload.documents.Transaction;
import com.motaz.preload.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("customer/{customerId}")
    public ResponseEntity<List<Transaction>> getTransactionByCustomerId(@PathVariable String customerId){
       Optional<List<Transaction>> optionalTransactions = transactionService.getTransactionByCustomerId(customerId);
        if(optionalTransactions.isPresent()) {
            return ResponseEntity.ok(optionalTransactions.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("customer/{customerId}/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionByCustomerIdAndAccountId(@PathVariable String customerId,
                                                                                    @PathVariable String accountId){
        Optional<List<Transaction>> optionalTransactions = transactionService.getTransactionByCustomerIdAndAccountId(customerId,accountId);
        if(optionalTransactions.isPresent()) {
            return ResponseEntity.ok(optionalTransactions.get());
        }
        return ResponseEntity.notFound().build();
    }

}
