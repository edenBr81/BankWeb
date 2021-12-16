package com.bankweb.transaction.model;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {



    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String identification;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private List<Address> addresses;
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
    private List<Account> accounts;

}
