package com.bankweb.account.service.impelmentation;


import com.bankweb.account.repository.AccountRepository;
import com.bankweb.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;
}
