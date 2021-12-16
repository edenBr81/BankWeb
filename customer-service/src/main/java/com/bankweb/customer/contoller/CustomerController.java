package com.bankweb.customer.contoller;


import com.bankweb.customer.entity.Customer;
import com.bankweb.customer.service.CustomerService;
import com.bankweb.customer.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer createAccount(@RequestBody Customer customer){
        return customerService.createAccount(customer);
    }
}
