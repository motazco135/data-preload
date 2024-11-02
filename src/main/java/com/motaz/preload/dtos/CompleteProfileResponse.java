package com.motaz.preload.dtos;

import com.motaz.preload.documents.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor
public class CompleteProfileResponse {

    private Customer customer;
    private List<AccountResponse> accounts;

}
