package com.bankweb.transaction.entity;


import com.bankweb.transaction.model.Account;
import com.bankweb.transaction.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String referenceNumber;
    private BigDecimal senderPrevBalance;
    private BigDecimal senderCurrentBalance;
    private BigDecimal receiverPrevBalance;
    private BigDecimal receiverCurrentBalance;
    private Date transactionDate;
    private String transactionBy;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private String senderAccountNumber;
    private String receiverAccountNumber;

}
