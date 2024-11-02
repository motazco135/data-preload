package com.motaz.preload.repositories;

import com.motaz.preload.documents.Transaction;
import com.redis.om.spring.repository.RedisDocumentRepository;

public interface TransactionRepository extends RedisDocumentRepository<Transaction,String> {

    Iterable<Transaction> findByCustomerId(String customerId);

    Iterable<Transaction> findByCustomerIdAndAccountId(String customerId, String accountId);

}
