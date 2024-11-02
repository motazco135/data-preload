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
@Document(value = "customer_profile_t_accounts",indexName = "AccountIdx")
public class Account {

    @Id
    @Indexed
    private String id ;

    @Indexed(fieldName = "account_number") //to search exact
    @SerializedName("account_number")
    private String accountNumber;

    @TagIndexed(fieldName = "account_status")//to search with contains
    @SerializedName("account_status")
    private String accountStatus;

    @SerializedName("account_balance")
    private String accountBalance;

    @Indexed
    @SerializedName("customer_id")
    private String customerId;

}
