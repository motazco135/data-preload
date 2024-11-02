package com.motaz.preload.api;

import com.motaz.preload.documents.Customer;
import com.motaz.preload.dtos.CompleteProfileResponse;
import com.motaz.preload.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerProfile(@PathVariable String customerId) {
        Optional<Customer> profile = customerService.getCustomerProfile(customerId);
        if(profile.isPresent()) {
           return ResponseEntity.ok(profile.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{customerId}/complete-profile")
    public ResponseEntity<CompleteProfileResponse> getCustomerCompleteProfile(@PathVariable String customerId) {
        Optional<CompleteProfileResponse> profile = customerService.getCustomerCompleteProfile(customerId);
        if(profile.isPresent()) {
            return ResponseEntity.ok(profile.get());
        }
        return ResponseEntity.notFound().build();
    }
}
