package com.motaz.preload.documents;

import com.google.gson.annotations.SerializedName;
import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.TagIndexed;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(value="customer_profile_t_transactions",indexName = "TransactionIdx")
public class Transaction {

    @Id
    @Indexed
    private String id;

    @SerializedName("transaction_ref_number")
    private String transactionRefNumber;

    @Indexed
    @SerializedName("customer_id")
    private String customerId;

    @Indexed
    @SerializedName("account_id")
    private String accountId;

    @SerializedName("transaction_amount")
    private String transactionAmount;

    @TagIndexed(fieldName = "transaction_type")
    @SerializedName("transaction_type")
    private String transactionType;

}
