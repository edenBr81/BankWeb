package com.bankweb.user.model;


import com.bankweb.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long accountId;
    private String accountNumber;
    private BigDecimal availableBalance;
    private BigDecimal actualBalanceAfter;
    private String accountStatus;
    private String accountType;


}
