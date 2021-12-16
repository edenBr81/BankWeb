package com.bankweb.account.service.impelmentation;


import com.bankweb.account.entity.Account;
import com.bankweb.account.model.*;
import com.bankweb.account.repository.AccountRepository;
import com.bankweb.account.service.AccountService;
import com.bankweb.account.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RestTemplate restTemplate;



    @Override
   public Account createAccount(User user, AccountType accountType, BigDecimal amount){
    Account account= new Account();
    account.setAccountNumber(generateAccountNumber(user.getFirstName(), user.getLastName()));
    account.setAccountStatus(AccountStatus.PENDING);
    account.setAccountType(accountType);
    account.setCurrentBalance(amount);
    account.setPreviousBalance(amount);
    user = restTemplate.postForObject("http://localhost:9000/user/createNew",user,User.class);
    if(user == null){
        return null;
    }
    account.setUserId(user.getId());
    return accountRepository.save(account);

   }

   private String generateAccountNumber(String firstName, String lastName){

        Integer latestAccountNumber=accountRepository.getMaxAccountNumber();

        StringBuilder start= new StringBuilder(firstName.substring(0, 2) + lastName.substring(0, 2));
        Integer newAccountNumber=latestAccountNumber+1;
        return start+newAccountNumber.toString();
   }


    @Override
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }


    @Override
    public void deposit(String accountNumber, BigDecimal amount) {

        Account account=accountRepository.findByAccountNumber(accountNumber);
        account.setPreviousBalance(account.getCurrentBalance());

        account.setCurrentBalance(account.getCurrentBalance().add(amount));

        accountRepository.save(account);

    }

    @Override
    public void withdraw(String accountNumber, BigDecimal amount) {


        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setPreviousBalance(account.getCurrentBalance());


        if (account.getCurrentBalance().compareTo(amount) > 0) {

            account.setCurrentBalance(account.getCurrentBalance().subtract(amount));

            accountRepository.save(account);
        }
    }

    @Override
    public List<Account> getByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }



    @Override
    @Transactional
    public Message transferMoney(TransferDto transferDto) {

             Account senderAccount= accountRepository.findByAccountNumber(transferDto.getSenderAccountNumber());


             if(senderAccount.getAccountStatus().equals(AccountStatus.ACTIVE) && senderAccount.getPreviousBalance().compareTo(transferDto.getAmount())>0) {
                 Account receiverAccount= accountRepository.findByAccountNumber(transferDto.getReceiverAccountNUmber());
                 if(receiverAccount.getAccountStatus().equals(AccountStatus.ACTIVE)){
                     senderAccount.setPreviousBalance(senderAccount.getCurrentBalance());
                     receiverAccount.setPreviousBalance(receiverAccount.getCurrentBalance());
                     senderAccount.setCurrentBalance((senderAccount.getCurrentBalance().subtract(transferDto.getAmount())));
                     receiverAccount.setCurrentBalance(receiverAccount.getPreviousBalance().add(transferDto.getAmount()));

                     Transaction transaction = new Transaction();
                     transaction.setReceiverAccountNumber(transferDto.getReceiverAccountNUmber());
                     transaction.setSenderAccountNumber(transferDto.getSenderAccountNumber());

                     transaction.setTransactionDate(new Date());
                     transaction.setReceiverCurrentBalance(receiverAccount.getCurrentBalance());
                     transaction.setReceiverPrevBalance(receiverAccount.getPreviousBalance());
                     transaction.setSenderCurrentBalance(senderAccount.getCurrentBalance());
                     transaction.setSenderPrevBalance(senderAccount.getPreviousBalance());
                     transaction.setTransactionType("TRANSFER");
                     transaction.setTransactionBy(transferDto.getTransactionBy());
                     transaction.setAmount(transferDto.getAmount());



                     transaction=restTemplate.postForObject("http://localhost:9000/transactions/create", transaction, Transaction.class);

                     accountRepository.save(senderAccount);
                     accountRepository.save(receiverAccount);

                     if(transaction==null){
                         return new Message(Message.Status.FAILED, "Transaction Not Completed");
                     }


                 }
                 else{
                     return new Message(Message.Status.FAILED, "Receiver account Not Active");
                 }

             }else{
                return new Message(Message.Status.FAILED, "Sender Account Not Active Or Doesn't has Sufficient Balance") ;
             }

        return new Message(Message.Status.SUCCESS,"Successful");
    }


}






















































//
//    @Override
//    public Account addAccountToExistingUser(Long userId, AccountType accountType) {
//
//        return "";
//
//    }