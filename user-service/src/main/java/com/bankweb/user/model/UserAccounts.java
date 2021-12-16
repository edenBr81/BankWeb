package com.bankweb.user.model;

import com.bankweb.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccounts {

    private List<Account> account;
    private User user;

}
