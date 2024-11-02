package com.motaz.preload.service;

import com.motaz.preload.documents.Transaction;
import com.motaz.preload.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Optional<List<Transaction>> getTransactionByCustomerId(String customerId){
        Iterable<Transaction> transactions = transactionRepository.findByCustomerId(customerId);
        Optional<List<Transaction>> optionalTransactions = Optional.ofNullable(transactions)
                .map(iterable -> StreamSupport.stream(iterable.spliterator(), false)
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty());
        return optionalTransactions;
    }

    public Optional<List<Transaction>> getTransactionByCustomerIdAndAccountId(String customerId,String accountId){
        Iterable<Transaction> transactions = transactionRepository.findByCustomerIdAndAccountId(customerId,accountId);
        Optional<List<Transaction>> optionalTransactions = Optional.ofNullable(transactions)
                .map(iterable -> StreamSupport.stream(iterable.spliterator(), false)
                        .collect(Collectors.toList()))
                .filter(list -> !list.isEmpty());
        return optionalTransactions;
    }
}
