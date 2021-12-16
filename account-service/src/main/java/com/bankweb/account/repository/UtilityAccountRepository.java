package com.bankweb.account.repository;

import com.bankweb.account.entity.UtilityAccount;
import com.bankweb.account.utils.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface UtilityAccountRepository extends JpaRepository<UtilityAccount, Long> {

    UtilityAccount findByProviderName(String providerName);
    UtilityAccount findByAccountNumber(String accountNumber);
    Message Pay(String senderAccountNUmber, String utilityProviderNUmber, String utilityAccountNumber, BigDecimal amount, String transferBy);
}
