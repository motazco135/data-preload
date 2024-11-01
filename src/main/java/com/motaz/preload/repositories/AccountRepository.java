package com.motaz.preload.repositories;

import com.motaz.preload.documents.Account;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends RedisDocumentRepository<Account,String> {
    Iterable<Account> findByCustomerId(Long customerId);
    // Define a method to find accounts by customerId
    //List<Account> findByCustomerId(String customerId);
}
