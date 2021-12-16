package com.bankweb.transaction.controller;


import com.bankweb.transaction.entity.Transaction;
import com.bankweb.transaction.service.TransactionService;
import com.bankweb.transaction.service.implemantation.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;



    @PostMapping("/create")
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.createTransaction(transaction);
    }

    @GetMapping("/getByAccountNum")
    public List<Transaction> getTransactionByAccountNumber(@RequestParam String accountNumber) {
        return transactionService.getTransactionByAccountNumber(accountNumber);
    }

}
