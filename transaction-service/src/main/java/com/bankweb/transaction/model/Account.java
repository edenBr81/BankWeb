package com.bankweb.transaction.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


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
        private Long  userId;





}
