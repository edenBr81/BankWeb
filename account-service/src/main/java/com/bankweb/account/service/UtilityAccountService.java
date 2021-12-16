package com.bankweb.account.service;

import com.bankweb.account.entity.UtilityAccount;
import com.bankweb.account.utils.Message;

import java.math.BigDecimal;

public interface UtilityAccountService {

    UtilityAccount findByProviderName(String providerName);
    UtilityAccount getUtilityAccountById(Long id);
    UtilityAccount findByAccountNumber(String accountNumber);
    Message Pay(String senderAccountNUmber, String utilityProviderNUmber, String utilityAccountNumber , BigDecimal amount, String transferBy);


}
