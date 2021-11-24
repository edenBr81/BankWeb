package com.bankweb.utility.account.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilityAccount {

    @Id
    private Long id;
    private int number;
    private String firstName;
    private String lastName;
}
