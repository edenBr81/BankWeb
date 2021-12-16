package com.bankweb.transaction.service.implemantation;


import com.bankweb.transaction.entity.Transaction;
import com.bankweb.transaction.model.Account;
import com.bankweb.transaction.repository.TransactionRepository;
import com.bankweb.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;


    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getTransactionByAccountNumber(String accountNumber) {
        return transactionRepository.getTransactionByAccountNumber(accountNumber);
    }
}
