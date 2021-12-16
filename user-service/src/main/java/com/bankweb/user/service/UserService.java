package com.bankweb.user.service;

import com.bankweb.user.entity.User;
import com.bankweb.user.model.UserAccounts;

import java.util.List;

public interface UserService {

    User findByUserId(Long id);
    User createUser(User user);
    UserAccounts getUserAccounts(Long userId);
























//
//    User findByIdentification(String identification);
//    List<User> findByAccountNumber(String AccountNumber);

}
