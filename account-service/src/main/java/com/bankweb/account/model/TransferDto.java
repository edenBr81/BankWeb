package com.bankweb.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {
    String senderAccountNumber;
    String receiverAccountNUmber;
    BigDecimal amount;
    String transactionBy;
}
