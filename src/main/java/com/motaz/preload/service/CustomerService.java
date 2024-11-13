package com.motaz.preload.service;

import com.motaz.preload.documents.Account;
import com.motaz.preload.documents.Customer;
import com.motaz.preload.documents.Transaction;
import com.motaz.preload.dtos.AccountResponse;
import com.motaz.preload.dtos.CompleteProfileResponse;
import com.motaz.preload.repositories.AccountRepository;
import com.motaz.preload.repositories.CustomerRepository;
import com.motaz.preload.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public Optional<Customer> getCustomerProfile(String customerId)  {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(optionalCustomer.get());
    }

    public Optional<CompleteProfileResponse> getCustomerCompleteProfile(String customerId){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            return Optional.empty();
        }
        Iterable<Account> accounts = accountRepository.findByCustomerId(customerId);
        List<AccountResponse> accountResponseList = new ArrayList<>();
        accounts.forEach(account -> {
            List<Transaction> recentTransactions = transactionRepository.findTop10ByAccountIdOrderByCreatedAtDesc(account.getId());
            accountResponseList.add(new AccountResponse(account,recentTransactions) );
        });

        return Optional.of(new CompleteProfileResponse(optionalCustomer.get(), accountResponseList));
    }


}
