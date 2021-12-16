package com.bankweb.account.repository;


import com.bankweb.account.entity.Account;
import com.bankweb.account.model.AccountType;
import com.bankweb.account.model.Transaction;
import com.bankweb.account.model.User;
import com.bankweb.account.entity.UtilityAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

     Account createAccount(User user, AccountType accountType, BigDecimal amount);
     List<Account> findByUserId(Long userId);
     Account findByAccountNumber(String accountNumber);
     @Query(value="select max(cast(SUBSTRING(a.accountNumber,4,9), int )) from Account a", nativeQuery = true)
     Integer getMaxAccountNumber();





























//     Account getAccountByIdentification(String identification);

}
