package com.bankweb.account.service.implementation;


import com.bankweb.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {


    @Autowired
    AccountRepository accountRepository;
}
