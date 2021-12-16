package com.bankweb.transaction.repository;

import com.bankweb.transaction.entity.Transaction;
import com.bankweb.transaction.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("SELECT t FROM Transaction t where t.senderAccountNumber= ?1 OR t.receiverAccountNumber=?1")
    List<Transaction> getTransactionByAccountNumber(String accountNumber);

}
