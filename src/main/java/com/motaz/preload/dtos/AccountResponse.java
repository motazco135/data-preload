package com.motaz.preload.dtos;

import com.motaz.preload.documents.Account;
import com.motaz.preload.documents.Transaction;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class AccountResponse {

    private Account account;
    private List<Transaction> transactions = Collections.emptyList();

    public AccountResponse(){}
    public AccountResponse(Account account, List<Transaction> transactions) {
        this.account = account;
        this.transactions = (transactions != null) ? transactions : Collections.emptyList();
    }

}
