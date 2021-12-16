package com.bankweb.account.controller;


import com.bankweb.account.entity.Account;
import com.bankweb.account.model.AccountType;
import com.bankweb.account.model.TransferDto;
import com.bankweb.account.model.User;
import com.bankweb.account.entity.UtilityAccount;
import com.bankweb.account.service.AccountService;
import com.bankweb.account.service.UtilityAccountService;
import com.bankweb.account.service.impelmentation.UtilityAccountServiceImpl;
import com.bankweb.account.utils.Message;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @Autowired
    UtilityAccountService utilityAccountService;


    @PostMapping("/createNew")
    public Account createNewAccount(@RequestBody User user, @RequestParam AccountType accountType, BigDecimal amount ){
        return accountService.createAccount(user,accountType,amount);
    }


    @GetMapping("/getById/{id}")
    public UtilityAccount getUtilityAccountById(@PathVariable("id") Long id){
        return utilityAccountService.getUtilityAccountById(id);
    }


    @GetMapping("/geyByUserId")
    public List<Account> getAllAccountByUserId(@RequestParam Long userId){
        return accountService.getByUserId(userId) ;
    }

    @GetMapping("/getByAccountNum")
    public Account getAccountByAccountNumber(@RequestParam String accountNumber){
        return accountService.findByAccountNumber(accountNumber);
    }

    @PostMapping("/deposit")
   public void deposit(@RequestParam String accountNumber, BigDecimal amount){

         accountService.deposit(accountNumber,amount);
   }

   @PostMapping("/withdraw")
    public void withdraw(@RequestParam String accountNumber, BigDecimal amount){
        accountService.withdraw(accountNumber,amount);
    }

    @PostMapping("/transfer")
    public Message transferMoney(@RequestBody TransferDto transferDto) {
      return accountService.transferMoney(transferDto);
    }

    @GetMapping("/byProvider")
    public UtilityAccount findByProviderName(@RequestParam String provider){
        return utilityAccountService.findByProviderName(provider);
    }

    @GetMapping("/accountNumber")
    public UtilityAccount findByAccountNumber(@RequestParam String accountNumber){
        return utilityAccountService.findByAccountNumber(accountNumber);
    }

    @PostMapping("/pay")
    public Message Pay(@RequestParam String senderAccountNUmber, @RequestParam String utilityProviderNUmber, @RequestParam String utilityAccountNumber, @RequestParam BigDecimal amount, @RequestParam String transferBy) {
        return utilityAccountService.Pay(senderAccountNUmber, utilityProviderNUmber, utilityAccountNumber, amount, transferBy );
    }


}
