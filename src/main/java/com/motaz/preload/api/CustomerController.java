package com.motaz.preload.api;

import com.motaz.preload.documents.Account;
import com.motaz.preload.documents.Customer;
import com.motaz.preload.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}/complete-profile")
    public ResponseEntity<Customer> getCustomerProfile(@PathVariable String customerId) {
        Optional<Customer> profile = customerService.getCustomerProfile(customerId);
        if(profile.isPresent()) {
           return ResponseEntity.ok(profile.get());
        }
        return ResponseEntity.notFound().build();
    }



}
