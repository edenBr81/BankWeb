package com.bankweb.account.entity;


import com.bankweb.account.model.AccountStatus;
import com.bankweb.account.model.AccountType;
import com.bankweb.account.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long accountId;
    private String accountNumber;
    private BigDecimal currentBalance;
    private BigDecimal amount;
    private BigDecimal previousBalance;
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private Long  userId;


}
