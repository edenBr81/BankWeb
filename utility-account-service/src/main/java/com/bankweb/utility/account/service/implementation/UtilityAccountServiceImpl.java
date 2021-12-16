package com.bankweb.utility.account.service.implementation;


import com.bankweb.utility.account.repository.UtilityAccountRepository;
import com.bankweb.utility.account.service.UtilityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilityAccountServiceImpl implements UtilityAccountService {

    @Autowired
    UtilityAccountRepository utilityAccountRepository;
}
