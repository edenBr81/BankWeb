package com.bankweb.transaction.service;

import com.bankweb.transaction.entity.Transaction;
import com.bankweb.transaction.model.Account;

import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);
    List<Transaction> getTransactionByAccountNumber(String accountNumber);

}
