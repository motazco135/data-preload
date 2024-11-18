package com.motaz.preload.repositories;

import com.motaz.preload.documents.AverageSpending;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageSpendingRepository extends RedisDocumentRepository<AverageSpending,String> {
}
