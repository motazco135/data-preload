package com.motaz.preload.api;

import com.motaz.preload.documents.Account;
import com.motaz.preload.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountsByCustomerId(@PathVariable String customerId) {
        Optional<List<Account>> accountDtos = accountService.getCustomerAccountList(customerId);
        if(accountDtos.isPresent()) {
            return ResponseEntity.ok(accountDtos.get());
        }
        return ResponseEntity.notFound().build();
    }
}
