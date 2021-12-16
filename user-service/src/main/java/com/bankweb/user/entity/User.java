package com.bankweb.user.entity;



import com.bankweb.user.model.Account;
import com.bankweb.user.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String identification;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Address> addresses;

}
