package com.motaz.preload.documents;


import com.google.gson.annotations.SerializedName;
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
@Document(value="customer_profile_t_customers",indexName = "CustomerIdx")
public class Customer {

    @Id
    @Indexed
    private String id;

    @Indexed
    @SerializedName("first_name")
    private String firstName;

    @Indexed
    @SerializedName("last_name")
    private String lastName;

    private String email;
    private String mobile;

}
