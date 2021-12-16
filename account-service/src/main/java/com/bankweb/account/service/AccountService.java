package com.bankweb.account.service;

import com.bankweb.account.entity.Account;
import com.bankweb.account.model.AccountType;
import com.bankweb.account.model.Transaction;
import com.bankweb.account.model.TransferDto;
import com.bankweb.account.model.User;
import com.bankweb.account.entity.UtilityAccount;
import com.bankweb.account.utils.Message;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface AccountService {

     Account createAccount(User user, AccountType accountType, BigDecimal amount);
     List<Account> getByUserId(Long userId);
     Message transferMoney(TransferDto transferDto);
     Account findByAccountNumber(String accountNumber);
     void deposit(String accountNumber, BigDecimal amount);
     void withdraw(String accountNumber, BigDecimal amount);












































     //     Account addAccountToExistingUser(Long userId,AccountType accountType);
//     Account getAccountById(Long id);
//     Account getAccountByIdentification(String identification);
}
