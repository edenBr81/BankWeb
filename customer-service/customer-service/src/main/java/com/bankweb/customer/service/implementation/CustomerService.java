package com.bankweb.customer.service.implementation;


import com.bankweb.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
}
