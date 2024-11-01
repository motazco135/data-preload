package com.motaz.preload.documents;

import com.google.gson.annotations.SerializedName;
import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.Searchable;
import com.redis.om.spring.annotations.TagIndexed;
import lombok.*;
import org.springframework.data.annotation.Id;


@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Document(value = "customer_profile_t_accounts",indexName = "AccountIdx")
public class Account {

    @Id
    @Indexed
    private String id ;

    @TagIndexed(fieldName = "account_number") //to search exact
    @SerializedName("account_number")
    private String accountNumber;

    @Indexed
    @Searchable(fieldName = "account_status")//to search with contains
    @SerializedName("account_status")
    private String accountStatus;

    @SerializedName("account_balance")
    private String accountBalance;

    @Indexed
    @TagIndexed(fieldName = "customer_id")
    @SerializedName("customer_id")
    private String customerId;

}
