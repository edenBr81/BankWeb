package com.bankweb.user.service.implementation;


import com.bankweb.user.entity.User;
import com.bankweb.user.model.Account;
import com.bankweb.user.model.UserAccounts;
import com.bankweb.user.repository.UserRepository;
import com.bankweb.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;


    public User createUser(User user){
        return userRepository.save(user);
    }


    @Override
    public User findByUserId(Long id) {
        return userRepository.findByUserId(id);
    }



    public UserAccounts getUserAccounts(Long userId){
        UserAccounts  userAccounts = new UserAccounts();
        User user = userRepository.getById(userId);
        List<Account> accounts = restTemplate.getForObject("http://localhost:9000/account/geyByUserId",List.class,userId);
        userAccounts.setUser(user);
        userAccounts.setAccount(accounts);
        return userAccounts;

    }































//    @Override
//    public List<User> findByAccountNumber(String accountNumber) {
//        return userRepository.findByAccountNumber(accountNumber);
//    }

//    public UserAccounts getUserAndAccount(Long id){
//
//        UserAccounts restTemp= new UserAccounts();
//
//        User user= userRepository.findByUserId(id);
//
//        Account account= restTemplate.getForObject("http://localhost:9007/account/getById/" + user.getAccountId(), Account.class);
//
//        restTemp.setUser(user);
//        restTemp.setAccount(account);
//
//        return restTemp;
//
//
//    }
//@Override
//public User findByIdentification(String identification) {
//    return userRepository.findByIdentification(identification);
//}
//
//    @Override
//    public User createAccount(User user, Account account){
//
//        return userRepository.save(user,account);
//    }
}
