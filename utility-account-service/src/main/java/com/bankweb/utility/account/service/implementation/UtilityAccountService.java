package com.bankweb.utility.account.service.implementation;


import com.bankweb.utility.account.repository.UtilityAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityAccountService {

    @Autowired
    UtilityAccountRepository utilityAccountRepository;
}
