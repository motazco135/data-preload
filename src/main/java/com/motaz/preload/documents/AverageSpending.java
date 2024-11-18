package com.motaz.preload.documents;


import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(value = "average-spending",indexName = "average-spendingIdx")
public class AverageSpending {

    @Id
    @Indexed
    private String customerId;
    private double averageSpending;
    private double totalAmount;
    private long transactionCount;

}
