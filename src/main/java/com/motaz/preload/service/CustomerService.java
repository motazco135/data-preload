package com.motaz.preload.service;

import com.motaz.preload.documents.Customer;
import com.motaz.preload.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> getCustomerProfile(String customerId)  {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(optionalCustomer.get());
    }

    public void getCustomerCompleteProfile(String customerId){
        //get customer profile
        //get customer account
    }


}
