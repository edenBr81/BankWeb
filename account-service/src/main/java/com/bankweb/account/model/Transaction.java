package com.bankweb.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {


    private Long id;
    private String referenceNumber;
    private BigDecimal senderPrevBalance;
    private BigDecimal senderCurrentBalance;
    private BigDecimal receiverPrevBalance;
    private BigDecimal receiverCurrentBalance;
    private BigDecimal amount;
    private Date transactionDate;
    private String transactionBy;
    private String transactionType;
    private String senderAccountNumber;
    private String receiverAccountNumber;
}