package com.motaz.preload.service;

import com.motaz.preload.documents.Account;
import com.motaz.preload.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public Optional<List<Account>> getCustomerAccountList(String customerId){
        try{
            Iterable<Account> accounts = accountRepository.findByCustomerId(customerId);
            Optional<List<Account>> optionalAccountList = Optional.ofNullable(accounts)
                    .map(iterable -> StreamSupport.stream(iterable.spliterator(), false)
                            .collect(Collectors.toList()))
                    .filter(list -> !list.isEmpty());
            return optionalAccountList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
