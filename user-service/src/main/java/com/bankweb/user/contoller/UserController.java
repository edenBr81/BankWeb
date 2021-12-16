package com.bankweb.user.contoller;



import com.bankweb.user.entity.User;
import com.bankweb.user.model.UserAccounts;
import com.bankweb.user.service.UserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userservice;



    @PostMapping("/createNew")
    public User createUser(@RequestBody User user){
        return userservice.createUser(user);
    }


    @GetMapping("/userAndAcounts/{userId}")
    public UserAccounts getUserAccounts(@RequestParam Long userId){
        return userservice.getUserAccounts(userId);
    }

    @GetMapping("/userById/{id}")
    public User getUserById(@RequestParam Long id){
        return userservice.findByUserId(id);
    }
























//    @GetMapping(value= "/find/{accountNumber}")
//    public List<User>  findByAccountNumber(@PathVariable("accountNumber") String accountNumber){
//        return findByAccountNumber(accountNumber);
//
//    }



//    @GetMapping(value= "/{id}")
//    public UserAccounts getUserAndAccount(@PathVariable("id") Long id){
//        return userservice.getUserAndAccount(id);
//    }
//    @GetMapping(value= "/{identification}")
//    public User findByIdentificationNumber(@PathVariable("identification") String identification){
//        return userservice.findByIdentification(identification);
//    }

}
