package com.motaz.preload.repositories;

import com.motaz.preload.documents.Customer;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends RedisDocumentRepository<Customer,String> {

}
