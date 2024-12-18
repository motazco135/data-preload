package com.motaz.preload.repositories;

import com.motaz.preload.documents.Account;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends RedisDocumentRepository<Account,String> {

    Iterable<Account> findByCustomerId(String customerId);
}
