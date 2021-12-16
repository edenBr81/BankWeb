package com.bankweb.customer.entity;


import com.bankweb.customer.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Address> address;

}
