package com.bankweb.customer.service.implementation;


import com.bankweb.customer.entity.Customer;
import com.bankweb.customer.repository.CustomerRepository;
import com.bankweb.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer createAccount(Customer customer){
         return customerRepository.save(customer);
    }
}
